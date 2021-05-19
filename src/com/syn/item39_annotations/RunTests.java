package com.syn.item39_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws ClassNotFoundException {

        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("com.syn.item39_annotations.Sample");

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;

                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable ex = wrappedExc.getCause();
                    System.out.println(method + " failed: " + ex);
                } catch (Exception ex) {
                    System.out.println("Invalid @Test: " + method);
                }
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
