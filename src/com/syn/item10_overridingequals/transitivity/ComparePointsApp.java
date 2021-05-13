package com.syn.item10_overridingequals.transitivity;

import java.awt.*;

public class ComparePointsApp {

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);

        ColorPoint cp1 = new ColorPoint(1, 1, Color.RED);
        ColorPoint cp2 = new ColorPoint(1, 1, Color.RED);

        System.out.println(cp1.equals(cp2));
        System.out.println(p1.equals(cp1));
        System.out.println(p1.equals(p2));
    }
}
