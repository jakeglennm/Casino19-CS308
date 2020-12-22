package com.example.loginattempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.loginattempt2.MESSAGE";

    private EditText username;
    private EditText password;
    private Button login;
    private Button signUp;
    private TextView failure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.username = (EditText)findViewById(R.id.loginUser);
        this.password = (EditText)findViewById(R.id.loginPassword);
        this.login = (Button)findViewById(R.id.loginBtn);
        this.signUp = (Button)findViewById(R.id.signUpBtn);
        this.failure = (TextView)findViewById(R.id.failures);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                logIn(username.getText().toString(), password.getText().toString());
            }
        });

    }

    private void logIn(String username, String password){
        if(username.equals("Test") && password.equals("password")){
            Intent entryPoint = new Intent(this, entryPoint.class);
            String message = username;
            entryPoint.putExtra(EXTRA_MESSAGE, message);
            startActivity(entryPoint);
        }else{
            failure.setText("Try again honey");
        }
    }

    public void signUp(View view){
        Intent createAccount = new Intent(this, createAccount.class);
        startActivity(createAccount);
    }
}