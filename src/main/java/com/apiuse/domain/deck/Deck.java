package com.apiuse.domain.deck;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.hand.Hand;

import java.util.List;

public interface Deck {

    List<Card> generateDeck();
    Hand dealHand(int handSize);

    List<Card> getCards();
}
