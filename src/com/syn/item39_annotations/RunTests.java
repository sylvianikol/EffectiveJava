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
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Exception>[] excTypes =
                            method.getAnnotation(ExceptionTest.class).value();
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", method, exc);
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
