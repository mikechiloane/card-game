package com.apiuse.domain.hand;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.card.Rank;
import com.apiuse.domain.card.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandEvaluatorTest {

    @Test
    @DisplayName("Test evaluateHand with Three of a Kind")
    public void testEvaluateHand() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));
        hand.add(new Card(Suit.HEARTS, Rank.KING));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.THREE_OF_A_KIND, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Four of a Kind")
    public void testEvaluateHand2() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE));
        hand.add(new Card(Suit.HEARTS, Rank.THREE));
        hand.add(new Card(Suit.SPADES, Rank.THREE));
        hand.add(new Card(Suit.HEARTS, Rank.KING));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.FOUR_OF_A_KIND, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Full House")
    public void testEvaluateHand3() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE));
        hand.add(new Card(Suit.HEARTS, Rank.THREE));
        hand.add(new Card(Suit.SPADES, Rank.KING));
        hand.add(new Card(Suit.HEARTS, Rank.KING));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.FULL_HOUSE, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Flush")
    public void testEvaluateHand4() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.CLUBS, Rank.FOUR));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.CLUBS, Rank.SIX));
        hand.add(new Card(Suit.CLUBS, Rank.KING));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.FLUSH, HandEvaluator.evaluateHand(hand).getRanking());

    }


    @Test
    @DisplayName("Test evaluateHand with Three of a Kind")
    public void testEvaluateHand6() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE));
        hand.add(new Card(Suit.HEARTS, Rank.THREE));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.THREE_OF_A_KIND, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Two Pair")
    public void testEvaluateHand7() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE));
        hand.add(new Card(Suit.HEARTS, Rank.FOUR));
        hand.add(new Card(Suit.SPADES, Rank.FOUR));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.TWO_PAIR, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with One Pair")
    public void testEvaluateHand8() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE));
        hand.add(new Card(Suit.HEARTS, Rank.FOUR));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.ONE_PAIR, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Straight")
    public void testEvaluateHand10() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        hand.add(new Card(Suit.HEARTS, Rank.FIVE));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.STRAIGHT, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Straight Flush")
    public void testEvaluateHand11() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.CLUBS, Rank.FOUR));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.CLUBS, Rank.SIX));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.STRAIGHT_FLUSH, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with High Card")
    public void testEvaluateHand12() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        hand.add(new Card(Suit.HEARTS, Rank.FIVE));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        hand.add(new Card(Suit.HEARTS, Rank.KING));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.HIGH_CARD, HandEvaluator.evaluateHand(hand).getRanking());

    }

    @Test
    @DisplayName("Test evaluateHand with Royal Flush")
    public void testEvaluateHand13() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.JACK));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN));
        hand.add(new Card(Suit.CLUBS, Rank.KING));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));

        HandEvaluator.evaluateHand(hand);

        assertEquals(HandRanking.FLUSH, HandEvaluator.evaluateHand(hand).getRanking());

    }
}
