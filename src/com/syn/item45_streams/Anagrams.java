package com.syn.item45_streams;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {

        List<String> dictionary = List.of("rat", "tar", "elbow", "below", "hello", "java");
        int minGroupSize = 2;

        Map<String, Set<String>> groups = new HashMap<>();

        for (String word : dictionary) {
            groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>())
                    .add(word);
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }

    private static String alphabetize(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
