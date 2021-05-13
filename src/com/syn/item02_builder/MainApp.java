package com.syn.item02_builder;


import static com.syn.item02_builder.NYPizza.Size.SMALL;
import static com.syn.item02_builder.Pizza.Topping.*;

public class MainApp {

    public static void main(String[] args) {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();

        NYPizza pizza = new NYPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
