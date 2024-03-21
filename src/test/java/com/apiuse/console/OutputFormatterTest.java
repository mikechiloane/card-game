package com.apiuse.console;

import com.apiuse.domain.card.Card;
import com.apiuse.domain.card.Rank;
import com.apiuse.domain.card.Suit;
import com.apiuse.domain.hand.HandRanking;
import com.apiuse.domain.hand.HandResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputFormatterTest {

    @Test
    public void testFormatHand_StraightFlush() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.KING));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN));
        hand.add(new Card(Suit.HEARTS, Rank.JACK));
        hand.add(new Card(Suit.HEARTS, Rank.TEN));

        HandResult result = new HandResult(HandRanking.STRAIGHT_FLUSH);

        String expected = "Your hand: A♥ K♥ Q♥ J♥ 10♥\nYou have: Straight Flush";
        String actual = OutputFormatter.formatHand(hand, result);

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatHand_FourOfAKind() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.KING));

        HandResult result = new HandResult(HandRanking.FOUR_OF_A_KIND);

        String expected = "Your hand: A♥ A♦ A♣ A♠ K♥\nYou have: Four of a Kind";
        String actual = OutputFormatter.formatHand(hand, result);

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatHand_FullHouse() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.KING));
        hand.add(new Card(Suit.HEARTS, Rank.KING));

        HandResult result = new HandResult(HandRanking.FULL_HOUSE);

        String expected = "Your hand: A♥ A♦ A♣ K♠ K♥\nYou have: Full House";
        String actual = OutputFormatter.formatHand(hand, result);

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatHand_Flush() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.KING));
        hand.add(new Card(Suit.HEARTS, Rank.JACK));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN));
        hand.add(new Card(Suit.HEARTS, Rank.TWO));

        HandResult result = new HandResult(HandRanking.FLUSH);

        String expected = "Your hand: A♥ K♥ J♥ 7♥ 2♥\nYou have: Flush";
        String actual = OutputFormatter.formatHand(hand, result);

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatHand_Straight() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.TEN));
        hand.add(new Card(Suit.DIAMONDS, Rank.NINE));
        hand.add(new Card(Suit.CLUBS, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));
        hand.add(new Card(Suit.HEARTS, Rank.SIX));

        HandResult result = new HandResult(HandRanking.STRAIGHT);

        String expected = "Your hand: 10♥ 9♦ 8♣ 7♠ 6♥\nYou have: Straight";
        String actual = OutputFormatter.formatHand(hand, result);

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatHand_ThreeOfAKind() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.KING));
        hand.add(new Card(Suit.HEARTS, Rank.TEN));

        HandResult result = new HandResult(HandRanking.THREE_OF_A_KIND);

        String expected = "Your hand: A♥ A♦ A♣ K♠ 10♥\nYou have: Three of a Kind";
        String actual = OutputFormatter.formatHand(hand, result);

        assertEquals(expected, actual);
    }

}
