package myProject.GamePieces;

import java.util.ArrayList;


public class Player {

	private String username;
	private Integer bet;
	private Hand hand;
	public int bestHand;
	public String turnAction;

	public Player(String userkey) {
		this.username = userkey;
		this.bet = 0;
		this.hand = new Hand();
		this.turnAction = "new";

	}
	
	public void reset() {
		turnAction = "new";
		hand = new Hand();
		bestHand = 0;
		bet = 0;
	}
	
	public void refresh() { 
		turnAction = "new"; 
	}
	
	public int getBestHandValue(){
		
		ArrayList<Integer> values = hand.getPossibleValues();
		ArrayList<Integer> removeValues = new ArrayList<Integer>();

		int closestTo21 = 0;
		
		for(Integer value: values) {
			if(value == 21) {
				bestHand = 21;
				blackjack();
				return 21;
			}else if (value > 21){
				
				removeValues.add(value);
			}
		}
		
		values.removeAll(removeValues);
		
		if(values.size() == 0) {
			bust();
			bestHand = -1;
			return -1; 
		}
		
		for(Integer value: values) {
			if(value > closestTo21) {
				closestTo21 = value;
			}
		}
		
		bestHand = closestTo21;
		return bestHand;
	}
	
	public void hit(Card card) { turnAction = "waiting"; addCardToHand(card); }
	public void stand() { turnAction = "standing"; }
	public void bust() { turnAction = "busted"; }
	public void blackjack() { turnAction = "blackjack"; }
	public void win() { turnAction = "won"; }
	public void lose() { turnAction = "lost"; }
	public void tie() { turnAction = "tied"; }
	
	public boolean hasBusted() {return turnAction.equals("busted"); }
	public void update() { getBestHandValue(); }
	
	public void addCardToHand(Card card) { hand.addCard(card); }
	public Integer addBet(int bet) { return this.bet += bet; }
	public Integer setBet(int bet) { return this.bet = bet; }

	public void setHand(Hand hand) { this.hand = hand; }
	
	public String getUsername() { return username; }
	public Integer getBet() { return bet; }
	public String getTurnAction() { return turnAction; }
	public Hand getHand() { return hand; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("Username: " + username + "\n");
		sb.append("   Bet: " + bet + "\n");
		
		sb.append(hand.toString());
		sb.append("Best Hand: " + bestHand + "\n");
		sb.append("Busted: " + hasBusted() + "\n");
		sb.append("State: " + getTurnAction() + "\n");

		
		return sb.toString();
	}
	
}
