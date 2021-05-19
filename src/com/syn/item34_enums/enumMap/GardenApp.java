package com.syn.item34_enums.enumMap;

import java.util.*;

import static com.syn.item34_enums.enumMap.Plant.LifeCycle.*;

public class GardenApp {

    public static void main(String[] args) {

        List<Plant> garden = List.of(
                new Plant("Rose", ANNUAL),
                new Plant("Strawberry", ANNUAL),
                new Plant("Daisy", PERENNIAL),
                new Plant("Potato", BIENNIAL)
        );

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }

        System.out.println(plantsByLifeCycle);
    }
}
