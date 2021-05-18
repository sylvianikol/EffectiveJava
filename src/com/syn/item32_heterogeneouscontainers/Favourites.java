package com.syn.item32_heterogeneouscontainers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favourites {

    private Map<Class<?>, Object> favourites = new HashMap<>();

    public <T> void putFavourite(Class<T> type, T instance) {
        favourites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavourite(Class<T> type) {
        return type.cast(favourites.get(type));
    }
}
