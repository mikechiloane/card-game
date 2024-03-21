package com.apiuse.domain.card;

public enum Suit {
    SPADES("♠"), // Use the spade symbol (Unicode character)
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}