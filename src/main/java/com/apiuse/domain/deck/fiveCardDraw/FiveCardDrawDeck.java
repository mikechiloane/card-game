package com.apiuse.domain.deck.fiveCardDraw;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.card.Rank;
import com.apiuse.domain.card.Suit;
import com.apiuse.domain.deck.Deck;
import com.apiuse.domain.hand.Hand;

import java.util.ArrayList;
import java.util.List;

public class FiveCardDrawDeck implements Deck {

    private final List<Card> cards;

    public FiveCardDrawDeck() {
        this.cards = generateDeck();
    }

    @Override
    public List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    @Override
    public Hand dealHand(int handSize) {
        if (cards.size() < handSize) {
            throw new IllegalArgumentException("Not enough cards in deck");
        }
        List<Card> handCards = new ArrayList<>(handSize);
        for (int i = 0; i < handSize; i++) {
            handCards.add(cards.remove(0));
        }
        return new Hand(handCards);
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }
}
