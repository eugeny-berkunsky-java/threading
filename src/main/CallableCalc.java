package main;

import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;

public class CallableCalc implements Callable<Double> {
    private Calculator calculator;

    public CallableCalc(double a, double b, int n, DoubleUnaryOperator f) {
        this.calculator = new Calculator(a,b,n,f);
    }

    @Override
    public Double call() throws Exception {
        return calculator.calc();
    }
}