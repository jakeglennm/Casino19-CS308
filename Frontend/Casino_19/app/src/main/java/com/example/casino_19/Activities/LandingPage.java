package com.example.casino_19.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.casino_19.Login.LoginActivity;
import com.example.casino_19.Login.SignUpActivity;
import com.example.casino_19.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Initial page users see where they choose whether to log in or register a new account
 */
public class LandingPage extends AppCompatActivity implements View.OnClickListener {

    private Button btnToLogin, btnToSignup;
    private Intent intent;

    /**
     * On creation of the page, the buttons are located and assigned click listeners
     * @param savedInstanceState passes any parameters of the saved app state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons
        this.btnToLogin = (Button) findViewById(R.id.toLoginButton);
        this.btnToSignup = (Button) findViewById(R.id.toSignupButton);

        // button click listeners (handled in "onClick")
        btnToSignup.setOnClickListener(this);
        btnToLogin.setOnClickListener(this);

        //initializing intent
        intent = new Intent();
    }

    /**
     * Redirects user to either the login activity or the sign up activity
     * @see LoginActivity
     * @see SignUpActivity
     * @param v passes which button was clicked
     */
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.toLoginButton){
            intent.setClass(this, LoginActivity.class);
        }else if(v.getId() == R.id.toSignupButton){
            intent.setClass(this, SignUpActivity.class);
        }

        startActivity(intent);

    }
}

