package com.apiuse.console;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.card.Rank;
import com.apiuse.domain.card.Suit;
import com.apiuse.domain.hand.HandResult;

import java.util.List;

public class OutputFormatter {
    public static String formatHand(List<Card> hand, HandResult result) {
        StringBuilder formattedHand = new StringBuilder("Your hand: ");
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            formattedHand.append(cardToString(card));
            if (i < hand.size() - 1) {
                formattedHand.append(" ");
            }
        }


        formattedHand.append("\nYou have: ").append(handResultToString(result));
        return formattedHand.toString();
    }

    private static String cardToString(Card card) {
        Rank rank = card.getRank();
        Suit suit = card.getSuit();
        return rankToString(rank) + suitToString(suit);
    }

    private static String rankToString(Rank rank) {
        switch (rank) {
            case ACE:
                return "A";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case TEN:
                return "10";
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
            default:
                return "";
        }
    }

    private static String suitToString(Suit suit) {
        switch (suit) {
            case CLUBS:
                return "♣";
            case DIAMONDS:
                return "♦";
            case HEARTS:
                return "♥";
            case SPADES:
                return "♠";
            default:
                return "";
        }
    }

    private static String handResultToString(HandResult handResult) {
        switch (handResult.getRanking()) {
            case HIGH_CARD:
                return "High Card";
            case ONE_PAIR:
                return "One Pair";
            case TWO_PAIR:
                return "Two Pair";
            case THREE_OF_A_KIND:
                return "Three of a Kind";
            case STRAIGHT:
                return "Straight";
            case FLUSH:
                return "Flush";
            case FULL_HOUSE:
                return "Full House";
            case FOUR_OF_A_KIND:
                return "Four of a Kind";
            case STRAIGHT_FLUSH:
                return "Straight Flush";
            default:
                return "";
        }
    }
}