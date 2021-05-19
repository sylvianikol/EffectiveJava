package com.syn.item34_enums.enumMap.garden;

import java.util.*;

import static com.syn.item34_enums.enumMap.garden.Plant.LifeCycle.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class GardenApp {

    public static void main(String[] args) {

        Plant[] garden = {
                new Plant("Rose", ANNUAL),
                new Plant("Strawberry", ANNUAL),
                new Plant("Daisy", PERENNIAL),
                new Plant("Potato", BIENNIAL)
        };

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }

        System.out.println(plantsByLifeCycle);
        System.out.println("-".repeat(10));

        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
