package com.example.casino_19.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.casino_19.Games.BlackJack.BlackJackActivity;
import com.example.casino_19.Login.LoginActivity;
import com.example.casino_19.Login.SignUpActivity;
import com.example.casino_19.R;

/**
 * Simple Dashboard for users to navigate the CASINO-19 application
 */
public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private Button btnToBlackjack;
    private Intent intent;

    /**
     * On creation of the Dashboard,
     * the button's are located and assigned click listeners
     * @param savedInstanceState the previous state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //buttons
        this.btnToBlackjack = (Button) findViewById(R.id.buttonBlackjack);

        // button click listeners (handled in "onClick")
        btnToBlackjack.setOnClickListener(this);

        //init intent
        intent = new Intent();
        intent.putExtra("ThisUser", getIntent().getSerializableExtra("ThisUser"));

    }

    //TODO Update when Poker and Leaderboard have Activities
    /**
     * When a button is clicked, this method is called.
     *
     * Utilizing the id of the button, the appropriate code is executed:
     * If blackjack is selected, the user will be redirected to the Blackjack Activity
     * @see BlackJackActivity
     *
     * - If poker is selected, the user will be redirected to the Poker Activity
     * 
     * @param v the current view of the app
     */
    @Override
    public void onClick(View v) {

        //TODO create activities for poker and leaderboard
        if(v.getId() == R.id.buttonBlackjack){
            intent.setClass(this, BlackJackActivity.class);
        }
        startActivity(intent);
  
    } 

}