package com.example.casino_19.Games.Pieces;

import java.util.ArrayList;
import java.util.List;

public class Hand{

    public ArrayList<Card> cards;

    // Initializes a single deck of cards
    public Hand(){
        cards = new ArrayList<Card>();
    }

    public List<Card> getCards() { return cards; }

    public boolean addCard(Card card) { return cards.add(card); }

    public ArrayList<Integer> getPossibleValues(){

        ArrayList<Integer> values = new ArrayList<Integer>();
        int value = 0;
        int numAces = 0;


        for(Card card: cards) {
            if(card.getValue() >= 10) {
                value += 10;
            }else if (card.getValue() == 1){
                numAces++;
            }else {
                value += card.getValue();
            }
        }

        if(numAces == 1) {
            values.add(value + 1);
            values.add(value + 11);
        }else if(numAces == 2) {
            values.add(value + 2);
            values.add(value + 12);
        }else if(numAces == 3) {
            values.add(value + 3);
            values.add(value + 13);
        }else if(numAces == 4) {
            values.add(value + 4);
            values.add(value + 14);
        }else {
            values.add(value);
        }

        return values;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   Cards: \n");

        if(!cards.isEmpty()) {
            for(Card card: cards) {
                sb.append("    " + card.toString() + ",\n");
            }
        }

        return sb.toString();

    }

}
