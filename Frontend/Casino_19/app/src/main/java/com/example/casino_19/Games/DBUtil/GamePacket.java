package com.example.casino_19.Games.DBUtil;

import com.example.casino_19.Games.Pieces.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


public class GamePacket {

    int ID;
    String type;
    ArrayList<Player> players;
    Player dealer;
    String gameString;

    public GamePacket(String type, int ID, ArrayList<Player> players, Player dealer){
        this.ID = ID;
        this.players = players;
        this.type = type;
        this.dealer = dealer;
        this.gameString = null;
    }

    public static GamePacket toGamePacket(String jsonString) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.fromJson(jsonString, GamePacket.class);
    }

    public Player getPlayerByUsername(String playerName) {
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

        sb.append("Type: ").append(type).append("\n");

        sb.append("Users: \n");

        for(Player player: players) {
            sb.append("  ").append(player.toString()).append("\n");
        }

        sb.append("Dealer: \n");
        sb.append("  ").append(dealer.toString()).append("\n");

        return sb.toString();
    }

    public String toString(String username){
        StringBuilder sb = new StringBuilder();

        sb.append(dealer.toString() + "\n");

        Player player = getPlayerByUsername(username);
        sb.append(player.toString() + "\n");


        return sb.toString();
    }

}
