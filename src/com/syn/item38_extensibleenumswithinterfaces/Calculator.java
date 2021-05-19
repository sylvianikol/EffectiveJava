package com.syn.item38_extensibleenumswithinterfaces;

public class Calculator {

    public static void main(String[] args) {

        double x = 2.0;
        double y = 4.0;

        // 1st approach
        calculate(ExtendedOperation.class, x, y);

        // 2nd approach
        // calculate(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    public static <T extends Enum<T> & Operation> void calculate(
            // 1st approach
            Class<T> opEnumType,
            // 2nd approach Collection<? extends Operation> opSet
            double x, double y) {

        for (Operation operation : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, operation, y, operation.apply(x, y));
        }
    }
}
