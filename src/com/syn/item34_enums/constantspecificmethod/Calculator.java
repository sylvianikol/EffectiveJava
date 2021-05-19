package com.syn.item34_enums.constantspecificmethod;

public class Calculator {

    public static void main(String[] args) {

        double x = 2.0;
        double y = 4.0;

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
