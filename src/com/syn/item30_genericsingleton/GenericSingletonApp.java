package com.syn.item30_genericsingleton;

import java.util.function.UnaryOperator;

public class GenericSingletonApp {

    public static void main(String[] args) {

        String[] stringsInput = { "one", "two", "three" };
        UnaryOperator<String> strings = GenericSingletonFactory.identityFunction();

        for (String string : stringsInput) {
            System.out.println(strings.apply(string));
        }

        Number[] numbersInput = { 1, 2.0, 3L };
        UnaryOperator<Number> numbers = GenericSingletonFactory.identityFunction();

        for (Number number : numbersInput) {
            System.out.println(numbers.apply(number));
        }

        System.out.println();
    }
}
