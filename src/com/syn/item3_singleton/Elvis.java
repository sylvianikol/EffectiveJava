package com.syn.item3_singleton;

public class Elvis {
    // 1st way -> public field approach
//    public static final Elvis INSTANCE = new Elvis();

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    // 2nd way -> static factory approach
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building.");
    }
}
