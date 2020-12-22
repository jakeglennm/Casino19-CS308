package com.example.casino_19.Games.Poker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.casino_19.Games.DBUtil.DBGameUtil;
import com.example.casino_19.Games.GameActivity;
import com.example.casino_19.R;
import com.example.casino_19.Users.User;

public class PokerActivity extends AppCompatActivity{
    // private TextView balance, gameTerminal;
    // private User user;
    // private Button buyIn5, buyIn10, buyIn25, buyIn50, buyIn100, checkBtn,
    // foldBtn;
    // //private WebSocketClient WebSocketClient; --may or may not need this
    // variable, possibly only in DBGameUtil
    //
    // private DBGameUtil gameUtil;
    // private PokerGame game;
    // private String terminalDisplay = "";
    // private int displayState = 0;
    // private int currentBuyIn = 0;
    //
    // @Override
    // protected void onCreate(Bundle savedInstanceState) {
    // super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_poker);
    // this.gameUtil = new DBGameUtil(this);
    // //this.WebSocketClient = gameUtil.getWebSocketClient();
    // //gameUtil.connectWebSocket();
    // this.game = new PokerGame(); //need to move poker logic to backend and modify
    // poker class for frontend
    //
    // //builds user that has been passed along
    // this.user = (User) getIntent().getSerializableExtra("ThisUser");
    //
    // //locate fields and set onClickListener for Buttons
    // this.balance = (TextView) findViewById(R.id.balance);
    // this.gameTerminal = (TextView) findViewById(R.id.blackjack_terminal);
    // this.buyIn5 = (Button) findViewById(R.id.bet_5_btn);
    // buyIn5.setOnClickListener(this);
    // this.buyIn10 = (Button) findViewById(R.id.bet_10_btn);
    // buyIn10.setOnClickListener(this);
    // this.buyIn25 = (Button) findViewById(R.id.bet_25_btn);
    // buyIn25.setOnClickListener(this);
    // this.buyIn50 = (Button) findViewById(R.id.bet_50_btn);
    // buyIn50.setOnClickListener(this);
    // this.buyIn100 = (Button) findViewById(R.id.bet_100_btn);
    // buyIn100.setOnClickListener(this);
    // this.checkBtn = (Button) findViewById(R.id.check_btn);
    // checkBtn.setOnClickListener(this);
    // this.foldBtn= (Button) findViewById(R.id.fold_btn);
    // foldBtn.setOnClickListener(this);
    //
    // //set initial balance user brings to the table
    // if(user != null){
    // balance.setText((user.getBalance()+""));
    // }
    // }
    //
    // @Override
    // public void onClick(View v) {
    // //use WebSocketClient.send("") to send data
    // //use WebSocketClient.close() when user exits game
    //
    // }
    //
    // @Override
    // public void updateBalanceDisplay(String response) {
    //
    // }
    //
    // @Override
    // public void updateUserBalance(int response) {
    //
    // }
}