package com.example.casino_19.Games.Pieces;

///**
// * Class for representing a playing card with possible rank 1 through 13 and four
// * possible suits.
// */
//public class Card implements CardInterface
//{
//    /**
//     * Suit for this card.
//     */
//    private final Suit suit;
//
//    /**
//     * Rank for this card.
//     */
//    private final int rank;
//
//    /**
//     * Names used for displaying rank value.
//     */
//    private final String[] NAMES = {"N/A",
//            "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
//            "Ten", "Jack", "Queen", "King"};
//
//    /**
//     * Constructs a card with the given rank and suit. Ranks are assumed to be in
//     * the range 1 through 13.
//     */
//    public Card(int givenRank, Suit givenSuit)
//    {
//        rank = givenRank;
//        suit = givenSuit;
//    }
//
//    /**
//     * returns the card's rank
//     * @return rank
//     */
//    @Override
//    public int getRank()
//    {
//        return rank;
//    }
//
//    /**
//     * returns the card's suit
//     * @return suit
//     */
//    @Override
//    public Suit getSuit()
//    {
//        return suit;
//    }
//
//    /**
//     * Returns a String representation of this card.
//     */
//    @Override
//    public String toString()
//    {
//        return NAMES[rank] + " of " + suit;
//    }
//
//}
import java.util.ArrayList;

public class Card {

    public enum Values{

        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING

    }

    public enum Suits{
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS,
    }

    Values rank;
    int value;
    Suits suit;

    public Card(Integer value, Integer suit){
        this.rank = Values.values()[value];
        this.suit = Suits.values()[suit];
        this.value = value + 1;
    }

    public Values getRank() { return rank; }
    public Suits getSuit() { return suit; }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}