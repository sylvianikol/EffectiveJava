package com.syn.item45_streams.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = newDeck();
    }

    public List<Card> newDeck() {
        // streams approach
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(toList());

        // classic iterative approach
//        List<Card> result = new ArrayList<>();
//        for (Suit suit : Suit.values()) {
//            for (Rank rank : Rank.values()) {
//                result.add(new Card(suit, rank));
//            }
//        }
//
//        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        cards.forEach(card -> sb.append(card)
                .append(System.lineSeparator()));

        return sb.toString();
    }
}
