package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private Button signOn;
    private Button signIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signOn = (Button) findViewById(R.id.signUp);
        signIn = (Button) findViewById(R.id.signIn);

        signOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewUserPage();
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignInPage();
            }
        });

    }

    private void openSignInPage() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }


    public void openNewUserPage(){

        Intent intent = new Intent(this , NewUserActivity.class);
        startActivity(intent);

    }


}