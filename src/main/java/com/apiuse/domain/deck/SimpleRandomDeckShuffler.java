package com.apiuse.domain.deck;

import java.util.Collections;
import java.util.Random;

public class SimpleRandomDeckShuffler implements Shuffler{
    @Override
    public void shuffleDeck(Deck deck) {
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
        Collections.shuffle(deck.getCards(), new Random());
    }

}
