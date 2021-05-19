package com.syn.item34_enums.constantspecificmethod;

public enum Operation {

    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
        },
    MINUS("-") {
        public  double apply(double x, double y) { return x - y; }
        },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
        },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
}
