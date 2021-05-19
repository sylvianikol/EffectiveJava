package com.syn.item39_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws ClassNotFoundException {

        int tests = 0;
        int passed = 0;

        Class<?> testSample = Class.forName("com.syn.item39_annotations.Sample");
        Class<?> testSample2 = Class.forName("com.syn.item39_annotations.Sample2");

        for (Method method : testSample2.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", method);
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    Class<? extends Throwable> excType =
                            method.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Test %s failed: expected %s, got %s%n",
                                method, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + method);
                }
            }
        }

//        for (Method method : testSample.getDeclaredMethods()) {
//            if (method.isAnnotationPresent(Test.class)) {
//                tests++;
//
//                try {
//                    method.invoke(null);
//                    passed++;
//                } catch (InvocationTargetException wrappedExc) {
//                    Throwable ex = wrappedExc.getCause();
//                    System.out.println(method + " failed: " + ex);
//                } catch (Exception ex) {
//                    System.out.println("Invalid @Test: " + method);
//                }
//            }
//        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
