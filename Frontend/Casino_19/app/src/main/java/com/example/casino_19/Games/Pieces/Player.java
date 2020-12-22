package com.example.casino_19.Games.Pieces;

import java.util.ArrayList;

public class Player {

    private String username;
    private Integer bet;
    public Hand hand;
    public int bestHand;
    private boolean busted;
    private String turnAction;

    public Player(String userkey) {
        this.username = userkey;
        this.bet = 0;
        this.hand = new Hand();
        this.turnAction = "waiting";

    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public String getUsername() { return username; }
    public Integer getBet() { return bet; }

    public Integer setBet(int bet) { return this.bet = bet; }
    public Integer addBet(int bet) { return this.bet += bet; }

    public void freshStart() {
        this.bet = 0;
        hand = new Hand();
        busted = false;
        turnAction = "waiting";
    }

    //new round, same cards, not new deal
    public void freshTurn() {

        if(turnAction.equals("standing")) {

        }else if(turnAction.equals("waiting")){

        }else if(turnAction.equals("busted")) {

        }

    }

    public void blackjack() {
        turnAction = "blackjack";
    }
    public void stand() {
        turnAction = "standing";
    }

    public void bust() {
        turnAction = "busted";
    }

    public void hit(Card card) {
        turnAction = "waiting";
        addCardToHand(card);
    }

    public String getTurnAction() {
        return turnAction;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean hasBusted() {return turnAction.equals("busted"); }

    public int getBestHandValue(){

        ArrayList<Integer> values = hand.getPossibleValues();
        ArrayList<Integer> removeValues = new ArrayList<Integer>();

        int closestTo21 = 0;


        for(Integer value: values) {

            if(value == 21) {
                bestHand = 21;
                return 21;
            }else if (value > 21){
                removeValues.add(value);
            }else {

            }
        }

        values.removeAll(removeValues);


        if(values.size() == 0) {
            this.bust();
            bestHand = -1;
            return -1; //busted
        }

        for(Integer value: values) {
            if(value > closestTo21) {
                closestTo21 = value;
            }
        }

        bestHand = closestTo21;

        return bestHand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Username> " + username + "\n");
        if(!this.username.equals("DEALER")){
        sb.append(" Bet: " + bet + "\n");}

        sb.append(hand.toString());
        sb.append(" Best Hand: " + bestHand + "\n");
        if(!turnAction.equals("won")&&!turnAction.equals("tied")&&!turnAction.equals("lost")&&!this.username.equals("DEALER")&&!turnAction.equals("new")){
        sb.append(" Current action: " + turnAction + "\n");}

        return sb.toString();
    }

}