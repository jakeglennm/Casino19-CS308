package myProject.Game;

import myProject.*;
import myProject.GamePieces.Deck;
import myProject.GamePieces.Player;
import myProject.UserDatabase.User;
import myProject.UserDatabase.UserDB;

import java.util.ArrayList;

public class GameState {	
	
	int ID;
	String type;
	
	Player dealer; 
	ArrayList<Player> players; 
	Deck deck;	
	
	Blackjack gameThread;
	GamePacket packet; 

	public GameState(String type, int ID, GameSocketServer socket){
		this.ID = ID;
		this.type = type;

		this.dealer = new Player("DEALER");
		this.players = new ArrayList<Player>();
		this.deck = new Deck();
		
		this.gameThread = new Blackjack(socket, this);
		this.packet = new GamePacket(this.type, this.ID, this.players, this.dealer);
	}
	
	
	public void drawCard(Player player) { player.addCardToHand(deck.drawCard()); }
	
	public boolean isFull() { if (players.size() >= 4) { return true; } else { return false; } } 
	public boolean isOpen() { if (players.size() < 4) { return true; } else { return false; } } 

	public int getID() { return ID; }
	public String getType() { return type; }
	
	public ArrayList<Player> getPlayers() { return players;}
	public void setDealer(Player dealer) { this.dealer = dealer; }
	
	public void addPlayer(Player player) { players.add(player); } 
	public void addPlayer(String username) { players.add(new Player(username)); } 
	public void removePlayer(Player player) {players.remove(player);}
	public void removePlayer(String playerName) { removePlayer(findPlayerByUsername(playerName));}

	public void addBetToPlayer(int bet, String username) { findPlayerByUsername(username).addBet(bet); }
	public void setBetToPlayer(int bet, String username) { findPlayerByUsername(username).setBet(bet); }
		
	public void setGameThread(Blackjack gameThread) { this.gameThread = gameThread; }
	public Blackjack getGameThread() { return this.gameThread; }
	
	
	public void deal() {
		
		drawCard(dealer);
		dealer.getBestHandValue();
		
		for(Player player: players) {
			drawCard(player);
			drawCard(player);
			player.getBestHandValue();
			
			if(player.getBestHandValue() == 21) {
				player.blackjack();
			}
			
		}
	
		updatePacket();
		
	}
	
	public void updatePlayers() {
		
		int dealerHandValue = dealer.getBestHandValue();

		if(dealer.getTurnAction().equals("blackjack")) {
			for(Player player : players) {
				if(player.getTurnAction().equals("blackjack")) {
					player.tie();
				}else{
					player.lose();
				}
			}
		}
		
		for(Player player : players) {
			
			int playerHandValue = player.getBestHandValue();
			
			if(playerHandValue == 21){
				player.win();
			}else if(dealerHandValue == -1) { //busted
				
				if(playerHandValue == -1) { //busted
					player.lose();
				}else {
					player.win();

				}
				
			}else {
				
				if(playerHandValue >= dealerHandValue) {
					player.win();

				}else {
					player.lose();
				}
				
			}	
								
		}
			
				
		updatePacket();
	}
	
	public void endGame() {

		for(Player player : players) {
			player.reset();
		}

		dealer.reset();
		deck.reshuffleDeck();
		updatePacket();
		
	}
	
	public GamePacket getPacket() {
		return packet;
	}
	
	
	public static void updateBalances(UserDB userdb, ArrayList<Player> players) {
		
		for(Player player : players) {
			
			User user = userdb.findByUsername(player.getUsername()).get(0);
			
			if(player.turnAction == "won") {
				user.adjustBalance(player.getBet());
			}else if(player.turnAction == "lost") {
				user.adjustBalance(player.getBet() * -1);
			}
			
			userdb.save(user);

		}
		
	}
	
	public void updateDealer() {
		
		drawCard(dealer);
		
		while(true)
		{

			int bestValue = dealer.getBestHandValue();
			String turnAction = dealer.getTurnAction();
			
			if(turnAction.equals("waiting") || turnAction.equals("new")) {
				
				if(bestValue > 21) {
					dealer.bust();
					//dealer busted
				}else if(bestValue < 17){
					dealer.hit(deck.drawCard());
				}else if(bestValue >= 17 && bestValue <= 21) {
					dealer.stand();
				}else {
					
				}
			}
			
			bestValue = dealer.getBestHandValue();
			dealer.bestHand = bestValue;
			if(bestValue == 21) {
				dealer.blackjack();
			}else if(bestValue > 21) {
				dealer.bust();
				//dealer busted
			}else if(bestValue >= 17 && bestValue <= 21) {
				dealer.stand();
			}	
			
			if(!dealer.turnAction.equals("waiting")) {
				break;
			}
			
		}
		
		updatePacket();

	}
	
	public void play(String action, String username) {
		
		Player player = findPlayerByUsername(username);
		
		if(player.turnAction.equals("waiting") || player.turnAction.equals("new")){
			
			player.turnAction = "waiting";
			
			if(action.equals("hit")) {
				player.hit(deck.drawCard());
				player.update();
			}else if(action.equals("stand")) {
				player.stand();
			}else if(action.equals("dd")) { //double down
			
			}else if(action.equals("split")) {
				
			}else {
				System.out.println("Invalid play: " + action);
			}
	
		}
			
	}
	

	public boolean gameOver() {		
				
		int flag = 0;
		
		for(Player player: players) {
			if(player.getTurnAction().equals("waiting") || player.getTurnAction().equals("new")) {
				flag = 1;
			}
		}
		
		if(flag == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void forceActions() {
		for(Player player : players) {
			if(player.turnAction.equals("new")){
				player.stand();
			}
		}
	}
	
	public void updatePacket() {
		packet = new GamePacket(type, ID, players, dealer);
	}
	
	public Player findPlayerByUsername(String playerName) {
		for(Player player: players) {
			if(player.getUsername().equalsIgnoreCase(playerName)) {
				return player;
			}
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Type: " + type + "\n");
		
		sb.append("Users: \n");
		
		for(Player player: players) {
			sb.append("  " + player.toString() + "\n");
		}
		
		sb.append("Dealer: \n");
		sb.append("  " + dealer.toString() + "\n");
		
		return sb.toString();
	}

	public boolean refreshPlayers() {
		for(Player player: players){
			player.refresh();
		}
		
		return true;
	}

}
