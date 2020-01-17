package main;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class Calculator {
    private double a;
    private double b;
    private int n;
    private DoubleUnaryOperator f;

    public Calculator(double a, double b, int n, DoubleUnaryOperator f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    public double calc() {
        double h = (b-a)/n;
        return IntStream.range(0, n)
                .mapToDouble(i -> a + i * h)
                .map(f)
//                .map(y -> y * h)
                .sum()*h;
//        IntStream.range(0, n)
    }
}
