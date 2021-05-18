package com.syn.item31_boundedwildcards.chooser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

    private final List<T> choiceArray;

    public Chooser(Collection<? extends T> choices) {
        choiceArray = new ArrayList<>(choices);
    }

    public T choose() {
        Random random = ThreadLocalRandom.current();
        return choiceArray.get(random.nextInt(choiceArray.size()));
    }
}
