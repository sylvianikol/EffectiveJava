package com.syn.item32_heterogeneouscontainers;

public class FavApp {

    public static void main(String[] args) {

        Favourites favourites = new Favourites();

        favourites.putFavourite(String.class, "Java");
        favourites.putFavourite(Integer.class, 0xcafebabe);
        favourites.putFavourite(Class.class, Favourites.class);

        String string = favourites.getFavourite(String.class);
        Integer integer = favourites.getFavourite(Integer.class);
        Class<?> clazz = favourites.getFavourite(Class.class);

        System.out.printf("%s %x %s%n", string, integer, clazz.getSimpleName());

    }
}
