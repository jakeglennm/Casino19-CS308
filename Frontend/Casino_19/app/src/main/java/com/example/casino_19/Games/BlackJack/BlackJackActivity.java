package com.example.casino_19.Games.BlackJack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.casino_19.Games.DBUtil.DBGameUtil;
import com.example.casino_19.Games.DBUtil.GamePacket;
import com.example.casino_19.Games.GameActivity;
import com.example.casino_19.R;
import com.example.casino_19.Users.User;

/**
 * BlackJackActivity is the class that handles the user interaction with the
 * blackjack game
 * 
 * @see BlackjackInterface
 * @see GameActivity
 */
public class BlackJackActivity extends AppCompatActivity implements BlackjackInterface, GameActivity {
    private TextView balance, gameTerminal;
    private User user;
    private Button doubleDownBtn;
    private Button splitBtn;

    private org.java_websocket.client.WebSocketClient WebSocketClient; // may or may not need this variable, possibly
                                                                       // only in DBGameUtil
    private GamePacket game;

    public int bet = 0;

    /**
     * Locates and assigns all of the buttons displayed by the Blackjack game. Gets
     * the user's information as well as retrieves from the database the user's
     * balance of currency
     * 
     * @param savedInstanceState any saved state information about the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);

        // builds user that has been passed along
        this.user = (User) getIntent().getSerializableExtra("ThisUser");

        RequestQueue queue = Volley.newRequestQueue(this);
        DBGameUtil gameUtil = new DBGameUtil(this, user.getUsername());

        gameUtil.connectWebSocket(user.getUsername(), "blackjack"); // connect webs-socket onCreate

        this.game = gameUtil.getGame();

        this.WebSocketClient = gameUtil.getWebSocketClient();

        // locate fields
        this.balance = findViewById(R.id.balance);
        this.gameTerminal = findViewById(R.id.terminal_display);
        this.doubleDownBtn = findViewById(R.id.double_down_btn);
        this.splitBtn = findViewById(R.id.split_btn);

        // set initial balance user brings to the table
        updateBalanceDisplay(user.getBalance() + "");
        // Initial display
        assert user != null;
        gameTerminal.append("dealer> Welcome " + user.getUsername());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        WebSocketClient.close();
    }

    /**
     * Sends the bet of the user through the socket
     * 
     * @param v View containing which bet button was selected
     */
    public void bet(View v) {

        WebSocketClient.send("balance:");
        switch (v.getId()) {
            case R.id.bet_5_btn:
                bet = 5;
                break;
            case R.id.bet_10_btn:
                bet = 10;
                break;
            case R.id.bet_25_btn:
                bet = 25;
                break;
            case R.id.bet_50_btn:
                bet = 50;
                break;
            case R.id.bet_100_btn:
                bet = 100;
                break;
        }

        gameTerminal.append("\n\n> Your bet is " + bet);

        WebSocketClient.send("bet:" + bet);
    }

    /**
     * The player hits
     * 
     * @param v information about the pressed button
     */
    public void hit(View v) {
        WebSocketClient.send("play:hit");
        gameTerminal.append(" Current action: waiting");
    }

    /**
     * The player stands
     * 
     * @param v information about the pressed button
     */
    public void stand(View v) {
        WebSocketClient.send("play:stand");
        gameTerminal.append(" Current action: standing");
    }

    /**
     * Doubles the player down
     * 
     * @param v information about the pressed button
     */
    public void doubleDown(View v) {
        WebSocketClient.send("play:dd");
        gameTerminal.append(" Current action: waiting");
    }

    /**
     * Splits the player's cards
     * 
     * @param v information about the pressed button
     */
    public void split(View v) {
        WebSocketClient.send("play:hit");
        gameTerminal.append(" Current action: waiting");
    }
    public void setGamePacket(GamePacket game) {
        this.game = game;
    }

    /*
     * method just for testing purposes
     */
    public void printToTerminal() {
        gameTerminal.setText(game.toString(user.getUsername()));
    }

    public void printToTerminal(String msg){ gameTerminal.setText(msg); }

    /**
     * Updates the user's balance from the DBGameUtil when response is received from
     * the server
     * 
     * @param updatedBalance new balance of the user from database
     */
    public void updateUserBalance(int updatedBalance) {
        user.setBalance(updatedBalance);
    }

    /**
     * Updates the displayed value of the user's balance
     * 
     * @param newBalance string value of the user's balance
     */
    public void updateBalanceDisplay(String newBalance) {
        balance.setText(checkBalance(newBalance));
    }

    /*
    For testing
     */
    public static String checkBalance(String newBalance){
        if(Integer.parseInt(newBalance) > 0){
            return newBalance;
        } else {
            return "you're broke";
        }
    }
}