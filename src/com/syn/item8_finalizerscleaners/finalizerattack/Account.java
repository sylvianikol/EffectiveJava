package com.syn.item8_finalizerscleaners.finalizerattack;

public class Account { // declare class final to prevent it from being extended

    public Account() {
        if (!isAuthorized()) {
            throw new SecurityException("You are not authorized to access this account!");
        }
    }

    // define method with 'final' to prevent it from being overridden by subclass
//    protected final void finalize() {}

    public boolean isAuthorized() {
        return false;
    }

    public void transferMoney(double amount) {
        System.out.println("Transferred " + amount);
    }
}
