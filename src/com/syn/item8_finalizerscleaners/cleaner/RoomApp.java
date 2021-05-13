package com.syn.item8_finalizerscleaners.cleaner;

public class RoomApp {
    public static void main(String[] args) {

        Room room = new Room(8);

        try {
            room.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
