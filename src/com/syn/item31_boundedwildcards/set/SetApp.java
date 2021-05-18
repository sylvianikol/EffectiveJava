package com.syn.item31_boundedwildcards.set;

import java.util.Set;

import static com.syn.item31_boundedwildcards.set.Utilities.union;

public class SetApp {

    public static void main(String[] args) {

        Set<Integer> integers = Set.of(1, 2, 3);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        Set<Number> numbers = union(integers, doubles);

        // Explicit type parameter - required prior to Java 8
        Set<Number> numbersPriorJava8 = Utilities.<Number>union(integers, doubles);

        numbers.forEach(System.out::println);
        System.out.println("-".repeat(10));
        numbersPriorJava8.forEach(System.out::println);
    }

}
