package com.syn.item8_finalizerscleaners.cleaner;

public class Adult {
    public static void main(String[] args) {

        try (Room room = new Room(8)) {
            System.out.println("Goodbye");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
