package com.syn.item8_finalizerscleaners.finalizerattack;

import java.util.concurrent.TimeUnit;

public class FinalizerAttack {

    public static void main(String[] args) throws InterruptedException {

        Account account = null;

        try {
            account = new FakeAccount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.gc();
        TimeUnit.MINUTES.sleep(10);
    }
}
