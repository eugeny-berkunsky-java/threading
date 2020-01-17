package main;

public class Main {

    double totalResult;
    int finished;

    public static void main(String[] args) {
	    new Main().run1();
	    new Main().run();
    }

    private void run() {
        double a = 0;
        double b = Math.PI;
        int n = 1000_000_000;
        int threads = 100;
        totalResult = 0;
        finished = 0;
        long start = System.currentTimeMillis();
        double delta = (b-a)/threads;
        for (int i = 0; i < threads; i++) {
            // Создать поток и запустить его
            MyThread myThread = new MyThread(this, a + i * delta, a + (i + 1) * delta, n / threads, Math::sin);
            new Thread(myThread).start();
        }

        //  ожидать завершения всех потоков
        synchronized (this) {
            try {
                while (finished < threads) {
                    wait();
                }
            } catch (InterruptedException e) {
                System.err.println("exception");
            }
        }
        long finish = System.currentTimeMillis();
        System.out.println("totalResult = " + totalResult);
        System.out.println("time = " + (finish - start));
    }

    private void run1() {
        Calculator calculator = new Calculator(0, Math.PI, 100_000_000, Math::sin);
        long start = System.currentTimeMillis();
        double v = calculator.calc();
        long finish = System.currentTimeMillis();
        System.out.println("v = " + v);
        System.out.println("time = " + (finish - start));
    }

    public synchronized void send(double v) {
        totalResult += v;
        finished++;
        notify();
    }
}
