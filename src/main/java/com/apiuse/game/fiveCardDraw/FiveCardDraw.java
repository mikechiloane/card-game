package com.apiuse.game.fiveCardDraw;

import com.apiuse.console.OutputFormatter;
import com.apiuse.domain.deck.Deck;
import com.apiuse.domain.deck.Shuffler;
import com.apiuse.domain.deck.SimpleRandomDeckShuffler;
import com.apiuse.domain.deck.fiveCardDraw.FiveCardDrawDeck;
import com.apiuse.domain.hand.Hand;
import com.apiuse.domain.hand.HandResult;
import com.apiuse.domain.hand.HandEvaluator;
import com.apiuse.game.cardGame;

public class FiveCardDraw implements cardGame {

    private final Deck deck = new FiveCardDrawDeck();
    private final Shuffler shuffler;

    public FiveCardDraw(Shuffler shuffler) {
        this.shuffler = shuffler;
    }

    public FiveCardDraw() {
        this.shuffler = new SimpleRandomDeckShuffler();
    }

    @Override
    public void run() {
        shuffler.shuffleDeck(deck);
        Hand hand = deck.dealHand(5);
        HandResult result = HandEvaluator.evaluateHand(hand.getCards());
        System.out.println(OutputFormatter.formatHand(hand.getCards(), result));
    }
}
