package myProject.Game;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import myProject.GamePieces.Card;
import myProject.GamePieces.Player;

public class GamePacket {

	int ID;
	String type;
	Player dealer;
	ArrayList<Player> players;
	String gameString; //to store message about game (not sure if needed yet)
	
	public GamePacket(String type, int ID, ArrayList<Player> players, Player dealer){
		this.ID = ID;
		this.players = players;
		this.type = type;
		this.dealer = dealer;
		this.gameString = "new game";
	}

	public int getID() { return ID; }
	public String getType() { return type; }
	public void setMessage(String message) { gameString = message; }
		
	public Player getPlayerByUsername(String playerName) {
		for(Player player: players) {
			if(player.getUsername().equalsIgnoreCase(playerName)) {
				return player;
			}
		}
		return null;
	}
	
	public String toJson() {
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String jsonString = gson.toJson(this);
		return jsonString;
		
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
		
		sb.append("Game Message: " + gameString + "\n");

		return sb.toString();
	}

}
