package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AccountCreatedActivity extends AppCompatActivity {

    TextView username;
    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_created);

        Intent intent = getIntent();

        username = findViewById(R.id.textViewUserName);
        email = findViewById(R.id.textViewEmail);
        password = findViewById(R.id.textViewPassword);

        username.setText(intent.getStringExtra("username"));
        password.setText(intent.getStringExtra("password"));
        email.setText(intent.getStringExtra("email"));

    }
}