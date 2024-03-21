package com.apiuse.domain.deck;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.deck.fiveCardDraw.FiveCardDrawDeck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SimpleRandomDeckShufflerTest {

    @Test
    public void testShuffleDeck() {

        Deck deck = new FiveCardDrawDeck();
        List<Card> originalDeck = new ArrayList<>(deck.getCards());
        List<Card> shuffledDeck;
        Shuffler shuffler = new SimpleRandomDeckShuffler();
        shuffler.shuffleDeck(deck);
        shuffledDeck = deck.getCards();
        assertNotEquals(originalDeck, shuffledDeck);
    }
}
