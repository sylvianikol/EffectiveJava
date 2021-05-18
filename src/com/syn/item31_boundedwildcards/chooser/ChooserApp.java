package com.syn.item31_boundedwildcards.chooser;

import java.util.List;

public class ChooserApp {

    List<Integer> integers = List.of( 1, 2, 3 );

    Chooser<Number> numberChooser = new Chooser<>(integers);
}
