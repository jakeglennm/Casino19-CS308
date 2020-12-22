package com.example.casino_19.Games.Pieces;

/**
 * Interface for the Card class
 * @see Card
 */
public interface CardInterface {
    /**
     * Enumerator for the Suits of cards
     */
    public enum Suit
    {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };
    /**
     * Returns the rank for this card.
     */
    public int getRank();

    /**
     * Returns the suit for this card.
     */
    public Suit getSuit();
}
