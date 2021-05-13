package com.syn.item8_finalizerscleaners.finalizerattack;

public class FakeAccount extends VulnerableAccount {

    public FakeAccount() {
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Transferring money via Fake account");
        this.transferMoney(1000);
        System.exit(0);
    }
}
