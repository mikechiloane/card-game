package com.apiuse.domain.hand;

import com.apiuse.domain.card.Card;

import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

}