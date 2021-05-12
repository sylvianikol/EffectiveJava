package com.syn.chapter2.item1_staticfactorymethod;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private static final String DEFAULT_COUNTRY = "Default Country";

    private static volatile User instance = null;

    private String name;
    private String email;
    private String country;

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public static User getInstance(String name, String email, String country) {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User(name, email, country);
                }
            }
        }

        return instance;
    }

    public static User createWithDefaultCountry(String name, String email) {
        return new User(name, email, DEFAULT_COUNTRY);
    }

    public static User createWithLoggedInstantiationTime(String name, String email, String country) {
        LOGGER.log(Level.INFO, "User created at : {0}", LocalTime.now());
        return new User(name, email, country);
    }
}
