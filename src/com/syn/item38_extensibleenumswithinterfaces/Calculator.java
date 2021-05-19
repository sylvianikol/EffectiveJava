package com.syn.item38_extensibleenumswithinterfaces;

public class Calculator {

    public static void main(String[] args) {

        double x = 2.0;
        double y = 4.0;

        calculate(ExtendedOperation.class, x, y);
    }

    public static <T extends Enum<T> & Operation> void calculate(Class<T> opEnumType, double x, double y) {

        for (Operation operation : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, operation, y, operation.apply(x, y));
        }
    }
}
