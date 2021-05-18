package com.syn.item31_boundedwildcards.set;

import java.util.HashSet;
import java.util.Set;

public class SetApp {

    public static void main(String[] args) {

        Set<Integer> integers = Set.of(1, 2, 3);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        Set<Number> numbers = union(integers, doubles);

        numbers.forEach(System.out::println);
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
