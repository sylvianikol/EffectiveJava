package com.syn.item31_boundedwildcards.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StackApp {

    public static void main(String[] args) {

        Stack<Number> stack = new Stack<>();
        Iterable<Integer> integers = List.of( 1, 2, 3 );

        stack.pushAll(integers);

//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        Collection<Object> collection = new ArrayList<>();
        stack.popAll(collection);

        collection.forEach(System.out::println);
    }
}
