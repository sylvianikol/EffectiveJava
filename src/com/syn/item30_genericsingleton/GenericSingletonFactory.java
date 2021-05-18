package com.syn.item30_genericsingleton;

import java.util.function.UnaryOperator;

public class GenericSingletonFactory {

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }
}
