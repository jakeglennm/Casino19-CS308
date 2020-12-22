package com.example.casino_19.Games.Pieces;

//import java.util.ArrayList;
//import java.util.Random;
//
///**
// * Class with a deck of 52 cards
// * @see Card
// */
//public class Deck
//{
//    /**
//     * The cards in this deck, as an ArrayList
//     * @see Card
//     */
//    private ArrayList<Card> cards;
//
//    private int size;
//
//    /**
//     * Constructs a new deck, calls deckInit().
//     */
//    public Deck()
//    {
//        deckInit();
//        size = cards.size();
//    }
//
//    /**
//     * returns 1 random card from an unsized deck of cards
//     * @return random Card as if enough decks were combined so that it did not matter the number of duplicates
//     * @see Card
//     */
//    public Card drawFromUnsizedDeck(){
//        Random rand = new Random();
//        return cards.get(rand.nextInt(cards.size()));
//    }
//
//    /**
//     * remove 1 card from deck at random
//     * @return a card from the deck and removed from the Deck
//     * @see Card
//     */
//    public Card selectCard()
//    {
//        Random rand = new Random();
//        return cards.remove(rand.nextInt(cards.size()));
//    }
//
//    /**
//     * remove card from deck that is specified
//     * @param card card to be removed from the deck
//     * @return boolean
//     */
//    public boolean removeCard(Card card)
//    {
//        return cards.remove(card);
//    }
//
//    /**
//     * add card to deck that is specified
//     * @param card card to be added to the deck
//     */
//    public void addCard(Card card)
//    {
//        if(cards.size()<52) cards.add(card);
//    }
//
//
//    /**
//     * Selects the given number from the deck and returns them in an ArrayList
//     * @param num integer number of cards to be returned in the hand of cards
//     * @return an ArrayList of type Card
//     */
//    public ArrayList<Card> selectCards(int num)
//    {
//        ArrayList<Card> ret = new ArrayList<Card>();
//        Random rand = new Random();
//        for(int i = 0; i<num; i++)
//        {
//            ret.add(cards.remove(rand.nextInt(cards.size())));
//        }
//        return ret;
//    }
//
//    /**
//     * Returns a string representation of the given card(s)
//     * @return string representation of cards
//     */
//    public String toString()
//    {
//        String ret = "";
//        for(int i = 0; i<cards.size();i++)
//        {
//            ret+= cards.get(i).toString() + "\n";
//        }
//        return ret;
//    }
//
//    /**
//     * returns size of deck
//     * @return integer size of Deck
//     */
//    public int getSize()
//    {
//        return cards.size();
//    }
//
//    /**
//     * creates a new deck of 52 cards
//     */
//    private void deckInit()
//    {
//        cards = new ArrayList<Card>();
//        int rank = 0;
//        for (rank = 1; rank <= 13; ++rank) {
//            cards.add(new Card(rank, Card.Suit.CLUBS));
//            cards.add(new Card(rank, Card.Suit.HEARTS));
//            cards.add(new Card(rank, Card.Suit.SPADES));
//            cards.add(new Card(rank, Card.Suit.DIAMONDS));
//        }
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    List<Card> cards, inPlay, inDeck;
    int numDecks;

    // Initializes the given number of decks of cards to be used
    public Deck(int numDecksInSet){

        this.numDecks = numDecksInSet;
        cards = generate(numDecksInSet);
        shuffleDeck();

        inPlay = new ArrayList<Card>();
        inDeck = cards;

    }

    // Initializes a single deck of cards
    public Deck(){
        this(1);
    }

    private ArrayList<Card> generate(int numDecks) {

        ArrayList<Card> cards = new ArrayList<Card>();

        for(int y = 0; y < numDecks; y++) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 13; j++) {
                    //set the deck when adding new card
                    cards.add(new Card(j,i));
                }
            }
        }

        return cards;
    }

    public List<Card> getCards() { return cards;}

    public Card drawCard() {
        Card card = inDeck.remove(0);
        inPlay.add(card);
        return card;
    }

    public void reshuffleDeck() {
        cards = generate(numDecks);
        shuffleDeck();
        inPlay.clear();
        inDeck = cards;
    }

    public Deck shuffleDeck() {
        Random rnd = new Random();
        int j = 0;

        for(int i = 0; i < 52; i++) {
            j = rnd.nextInt(52);
            swap(i,j);
        }
        return this;

    }

    private void swap(int i, int j) {

        //System.out.println("swapping " + i + " with " + j);
        Card temp = null;

        temp = cards.get(j);
        cards.set(j, cards.get(i));
        cards.set(i, temp);

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Cards in deck: \n");

        for(Card card: inDeck) {
            sb.append(card.toString() + "\n");
        }

        sb.append("Cards in deck: \n");

        for(Card card: inPlay) {
            sb.append(card.toString() + "\n");
        }

        return sb.toString();
    }

}


