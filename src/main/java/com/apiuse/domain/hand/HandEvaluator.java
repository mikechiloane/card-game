package com.apiuse.domain.hand;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.card.Rank;
import com.apiuse.domain.card.Suit;

import java.util.*;

public class HandEvaluator {

    private static boolean isStraight(List<Card> hand) {
        hand.sort(Comparator.comparingInt(card -> card.getRank().getValue()));

        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank().getValue() + 1 != hand.get(i + 1).getRank().getValue()) {
                return false;
            }
        }
        return true;
    }

    public static HandResult evaluateHand(List<Card> hand) {
        Map<Rank, Integer> rankCount = countRanks(hand);
        int flushCount = countFlush(hand);

        if (isStraightFlush(hand, flushCount)) {
            return new HandResult(HandRanking.STRAIGHT_FLUSH);
        }

        if (isFourOfAKind(rankCount)) {
            return new HandResult(HandRanking.FOUR_OF_A_KIND);
        }

        if (isFullHouse(rankCount)) {
            return new HandResult(HandRanking.FULL_HOUSE);
        }

        if (flushCount == hand.size()) {
            return new HandResult(HandRanking.FLUSH);
        }

        if (isStraight(hand)) {
            return new HandResult(HandRanking.STRAIGHT);
        }

        if (isThreeOfAKind(rankCount)) {
            return new HandResult(HandRanking.THREE_OF_A_KIND);
        }

        if (isTwoPair(rankCount)) {
            return new HandResult(HandRanking.TWO_PAIR);
        }

        if (isOnePair(rankCount)) {
            return new HandResult(HandRanking.ONE_PAIR);
        }

        return new HandResult(HandRanking.HIGH_CARD, findHighCards(hand));
    }

    private static Map<Rank, Integer> countRanks(List<Card> hand) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount;
    }

    private static int countFlush(List<Card> hand) {
        Suit flushSuit = hand.get(0).getSuit();
        int flushCount = 0;
        for (Card card : hand) {
            if (card.getSuit() == flushSuit) {
                flushCount++;
            }
        }
        return flushCount;
    }

    private static boolean isStraightFlush(List<Card> hand, int flushCount) {
        return flushCount == hand.size() && isStraight(hand);
    }

    private static boolean isFourOfAKind(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(4);
    }

    private static boolean isFullHouse(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(3) && rankCount.containsValue(2);
    }

    private static boolean isThreeOfAKind(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(3);
    }

    private static boolean isTwoPair(Map<Rank, Integer> rankCount) {
        int pairCount = 0;
        for (Integer count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private static boolean isOnePair(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(2);
    }

    private static List<Rank> findHighCards(List<Card> hand) {
        List<Rank> highCards = new ArrayList<>();
        int highestValue = 0;
        for (Card card : hand) {
            highestValue = Math.max(highestValue, card.getRank().getValue());
        }
        highCards.add(Rank.values()[highestValue - 1]);
        return highCards;
    }


}
