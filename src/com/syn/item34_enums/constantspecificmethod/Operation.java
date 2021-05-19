package com.syn.item34_enums.constantspecificmethod;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

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

    private static final Map<String, Operation> stringToEnum = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    @Override
    public String toString() {
        return symbol;
    }
}
