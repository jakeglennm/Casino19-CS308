package com.example.casino_19.Games.DBUtil;

import android.util.Log;
import com.example.casino_19.Games.BlackJack.BlackJackActivity;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;

public class DBGameUtil implements DBGameInterface {
    private BlackJackActivity gameActivity;

    public static final String wsURI = "ws://coms-309-rp-10.cs.iastate.edu:8080/chat/";
    //"ws://25.11.170.226:8080/chat/";
    //"ws://coms-309-rp-10.cs.iastate.edu:8080/chat/";
    //"ws://echo.websocket.org"
    //"ws://localhost:8080/chat/";
    // ws://localhost:8080/chat/{user name}/{type};

    private WebSocketClient WebSocketClient;
    private String username;
    private GamePacket game;

    public DBGameUtil(BlackJackActivity view, String username) {
        this.gameActivity = view;
        this.username = username;
    }

    ///////////////////////////////////////////
    // web socket implementation below
    ///////////////////////////////////////////

    public void connectWebSocket(final String username, String gameType) {
        URI uri;
        try {
            uri = new URI(wsURI + username + "/" + gameType);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        WebSocketClient = new WebSocketClient(uri) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                Log.i(String.valueOf(serverHandshake.getHttpStatus()), serverHandshake.getHttpStatusMessage());
            }

            @Override
            public void onMessage(String msg) {
                Log.i("Websocket", msg);
                if(msg.startsWith("balance:")){
                    int startInd = msg.indexOf(":");
                    gameActivity.updateBalanceDisplay(msg.substring(startInd+1));
                    gameActivity.updateUserBalance(Integer.parseInt(msg.substring(startInd+1)));
                }
                game = GamePacket.toGamePacket(msg);
                gameActivity.setGamePacket(game);
                gameActivity.printToTerminal();
                if (game.gameString.equals("Game Over")){
                    if(game.getPlayerByUsername(username).getTurnAction().equals("won")){
                        gameActivity.printToTerminal(game.toString(username) + "you won!! Please place a bet for a new game");
                    } else if(game.getPlayerByUsername(username).getTurnAction().equals("tied")){
                        gameActivity.printToTerminal(game.toString(username) + "you tied.. Please place a bet for a new game");
                    } else if(game.getPlayerByUsername(username).getTurnAction().equals("lost")) {
                        gameActivity.printToTerminal(game.toString(username) + "you lost :) Please place a bet for a new game");
                    }
                    this.send("balance:");
                }
            }

            @Override
            public void onClose(int errorCode, String reason, boolean remote) {
                Log.i("Websocket", "Closed " + reason);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        WebSocketClient.connect();
    }

    public WebSocketClient getWebSocketClient() {
        return WebSocketClient;
    }

    public GamePacket getGame() {
        return game;
    }

}
