package com.syn.item8_finalizerscleaners.finalizerattack;

import java.util.concurrent.TimeUnit;

public class FinalizerAttack {

    public static void main(String[] args) throws InterruptedException {

        try {
            VulnerableAccount account = new FakeAccount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.gc(); // increases the odds of finalizers or cleaners getting executed, but doesn't guarantee it
        TimeUnit.MINUTES.sleep(10);
    }
}
