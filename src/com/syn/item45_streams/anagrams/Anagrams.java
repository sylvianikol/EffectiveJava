package com.syn.item45_streams.anagrams;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {

    public static void main(String[] args) {

        List<String> dictionary = List.of("rat", "tar", "elbow", "below", "hello", "java");
        int minGroupSize = 2;

        // 2nd solution
        dictionary.stream()
                .collect(groupingBy(Anagrams::alphabetize))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .forEach(group -> System.out.println(group.size() + ": " + group));

        System.out.println("-".repeat(20));

        // 1st solution
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
