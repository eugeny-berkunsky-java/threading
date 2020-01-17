package main;

import java.util.function.DoubleUnaryOperator;

public class MyThread implements Runnable {
    private Main main;
    private Calculator calculator;

    public MyThread(Main main, double a, double b, int n, DoubleUnaryOperator f) {
        this.main = main;
        this.calculator = new Calculator(a,b,n,f);
    }

    @Override
    public void run() {
        double v = calculator.calc();
        main.send(v);
    }
}
