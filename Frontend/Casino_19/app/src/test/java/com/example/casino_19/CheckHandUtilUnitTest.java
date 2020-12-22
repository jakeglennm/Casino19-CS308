package com.example.casino_19;

import com.example.casino_19.Games.Pieces.CardInterface;
import com.example.casino_19.Games.Poker.CheckHandUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class CheckHandUtilUnitTest {

//    @Test
//    public void testFindIndexOfMin1()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(9);
//        when(card1.getRank()).thenReturn(7);
//        when(card2.getRank()).thenReturn(8);
//        when(card3.getRank()).thenReturn(1); //index 3
//        when(card4.getRank()).thenReturn(7);
//        when(card5.getRank()).thenReturn(2);
//        when(card6.getRank()).thenReturn(4);
//
//        when(card0.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card1.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card2.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card3.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card4.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card5.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card6.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//
//        CardInterface[] mockCards = {card0, card1, card2, card3, card4, card5, card6};
//
//        //if all suits are the same, then it will just compare by rank
//        int min = util.findIndexOfMin(0, mockCards);
//
//        assertEquals(3,min);
//
//    }
//
//    @Test
//    public void testFindIndexOfMin2()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(9);
//        when(card1.getRank()).thenReturn(7);
//        when(card2.getRank()).thenReturn(8);
//        when(card3.getRank()).thenReturn(1);
//        when(card4.getRank()).thenReturn(7);
//        when(card5.getRank()).thenReturn(2);
//        when(card6.getRank()).thenReturn(4);
//
//        // enum defined in this order: CLUBS, DIAMONDS, HEARTS, SPADES
//        when(card0.getSuit()).thenReturn(CardInterface.Suit.SPADES);
//        when(card1.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card2.getSuit()).thenReturn(CardInterface.Suit.DIAMONDS);
//        when(card3.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card4.getSuit()).thenReturn(CardInterface.Suit.CLUBS); // index = 4, clubs is considered lowest rank
//        when(card5.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card6.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//
//        CardInterface[] mockCards = {card0, card1, card2, card3, card4, card5, card6};
//
//        // if suits are different it will compare by suit in order of how enum was declared
//        int min = util.findIndexOfMin(0, mockCards);
//
//        assertEquals(4,min);
//
//    }
//
//    @Test
//    public void testIsPair()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(1);
//        when(card2.getRank()).thenReturn(3);
//        when(card3.getRank()).thenReturn(5);
//        when(card4.getRank()).thenReturn(7);
//        when(card5.getRank()).thenReturn(9);
//        when(card6.getRank()).thenReturn(11);
//
//        //pair with Aces
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isPair(mockHand));
//        assertEquals(false,util.isTwoPair(mockHand));
//
//    }
//
//    @Test
//    public void testIsTwoPair()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(1);
//        when(card2.getRank()).thenReturn(3);
//        when(card3.getRank()).thenReturn(5);
//        when(card4.getRank()).thenReturn(7);
//        when(card5.getRank()).thenReturn(9);
//        when(card6.getRank()).thenReturn(7);
//
//        //2 pair with Aces and 7's, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isTwoPair(mockHand));
//        assertEquals(false, util.isThreeKind(mockHand));
//    }
//
//    @Test
//    public void testIsThreeKind()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(1);
//        when(card2.getRank()).thenReturn(11);
//        when(card3.getRank()).thenReturn(5);
//        when(card4.getRank()).thenReturn(11);
//        when(card5.getRank()).thenReturn(9);
//        when(card6.getRank()).thenReturn(11);
//
//        //three of a kind with 3 11's, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isThreeKind(mockHand));
//        assertEquals(false, util.isFourKind(mockHand));
//    }
//
//    @Test
//    public void testIsStraight1()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(1);
//        when(card2.getRank()).thenReturn(3);
//        when(card3.getRank()).thenReturn(4);
//        when(card4.getRank()).thenReturn(6);
//        when(card5.getRank()).thenReturn(5);
//        when(card6.getRank()).thenReturn(7);
//
//        //Straight from 3-7, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isStraight(mockHand));
//        assertEquals(false, util.isFullHouse(mockHand));
//    }
//
//    @Test
//    public void testIsStraight2()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(1);
//        when(card2.getRank()).thenReturn(3);
//        when(card3.getRank()).thenReturn(13);
//        when(card4.getRank()).thenReturn(11);
//        when(card5.getRank()).thenReturn(12);
//        when(card6.getRank()).thenReturn(10);
//
//        //Straight from 10-1, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isStraight(mockHand));
//        assertEquals(false, util.isFullHouse(mockHand));
//    }
//
//    @Test
//    public void testIsFlush()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getSuit()).thenReturn(CardInterface.Suit.CLUBS);
//        when(card1.getSuit()).thenReturn(CardInterface.Suit.CLUBS);
//        when(card2.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card3.getSuit()).thenReturn(CardInterface.Suit.SPADES);
//        when(card4.getSuit()).thenReturn(CardInterface.Suit.CLUBS);
//        when(card5.getSuit()).thenReturn(CardInterface.Suit.CLUBS);
//        when(card6.getSuit()).thenReturn(CardInterface.Suit.CLUBS);
//
//        //Straight from 3-7, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isFlush(mockHand));
//    }
//
//    @Test
//    public void testIsFullHouse()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(3);
//        when(card1.getRank()).thenReturn(1);
//        when(card2.getRank()).thenReturn(3);
//        when(card3.getRank()).thenReturn(5);
//        when(card4.getRank()).thenReturn(7);
//        when(card5.getRank()).thenReturn(5);
//        when(card6.getRank()).thenReturn(5);
//
//        //full house with 2 3's and 3 5's, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isFullHouse(mockHand));
//        assertEquals(false, util.isFourKind(mockHand));
//    }
//
//    @Test
//    public void testIsFourKind()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(9);
//        when(card1.getRank()).thenReturn(9);
//        when(card2.getRank()).thenReturn(3);
//        when(card3.getRank()).thenReturn(9);
//        when(card4.getRank()).thenReturn(6);
//        when(card5.getRank()).thenReturn(9);
//        when(card6.getRank()).thenReturn(7);
//
//        //Four of a kind with 9's, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isFourKind(mockHand));
//        assertEquals(false, util.isStraight(mockHand));
//    }
//
//    @Test
//    public void testIsStraightFlush()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(3);
//        when(card2.getRank()).thenReturn(5);
//        when(card3.getRank()).thenReturn(6);
//        when(card4.getRank()).thenReturn(7);
//        when(card5.getRank()).thenReturn(8);
//        when(card6.getRank()).thenReturn(9);
//        when(card0.getSuit()).thenReturn(CardInterface.Suit.CLUBS);
//        when(card1.getSuit()).thenReturn(CardInterface.Suit.SPADES);
//        when(card2.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card3.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card4.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card5.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card6.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//
//        //Straight flush from 5-9 with hearts, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isStraight(mockHand));
//        assertEquals(true, util.isFlush(mockHand));
//        assertEquals(true, util.isStraightFlush(mockHand));
//        assertEquals(false, util.isRoyalFlush(mockHand));
//    }
//
//    @Test
//    public void testIsRoyalFlush()
//    {
//        CheckHandUtil util = new CheckHandUtil();
//
//        CardInterface card0 = mock(CardInterface.class);
//        CardInterface card1 = mock(CardInterface.class);
//        CardInterface card2 = mock(CardInterface.class);
//        CardInterface card3 = mock(CardInterface.class);
//        CardInterface card4 = mock(CardInterface.class);
//        CardInterface card5 = mock(CardInterface.class);
//        CardInterface card6 = mock(CardInterface.class);
//
//        when(card0.getRank()).thenReturn(1);
//        when(card1.getRank()).thenReturn(10);
//        when(card2.getRank()).thenReturn(11);
//        when(card3.getRank()).thenReturn(12);
//        when(card4.getRank()).thenReturn(13);
//        when(card5.getRank()).thenReturn(4);
//        when(card6.getRank()).thenReturn(6);
//        when(card0.getSuit()).thenReturn(CardInterface.Suit.DIAMONDS);
//        when(card1.getSuit()).thenReturn(CardInterface.Suit.DIAMONDS);
//        when(card2.getSuit()).thenReturn(CardInterface.Suit.DIAMONDS);
//        when(card3.getSuit()).thenReturn(CardInterface.Suit.DIAMONDS);
//        when(card4.getSuit()).thenReturn(CardInterface.Suit.DIAMONDS);
//        when(card5.getSuit()).thenReturn(CardInterface.Suit.HEARTS);
//        when(card6.getSuit()).thenReturn(CardInterface.Suit.SPADES);
//
//        //Royal Flush with diamonds, order doesn't matter because it gets sorted before it checks the hand
//        CardInterface[] mockHand = {card0,card1,card2,card3,card4,card5,card6};
//
//        assertEquals(true, util.isStraightFlush(mockHand));
//        assertEquals(true, util.isRoyalFlush(mockHand));
//        assertEquals(false, util.isFullHouse(mockHand));
//    }

}