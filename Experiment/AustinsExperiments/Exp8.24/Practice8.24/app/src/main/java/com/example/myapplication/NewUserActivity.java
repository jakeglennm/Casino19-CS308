package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class NewUserActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText email;
    private Button submitButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        submitButton = (Button) findViewById(R.id.finishButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = findViewById(R.id.editTextUserName);
                password = findViewById(R.id.editTextPassword);
                email = findViewById(R.id.editTextEmailAddress);

                user = new User(email.getText().toString(),
                                username.getText().toString(),
                                password.getText().toString());

                String json = User.toJSon(user);

                try{
                    FileWriter file = new FileWriter("helpme.json");
                    file.write(json);
                    file.close();

                }catch (IOException ex){
                    ex.printStackTrace();
                }




                openAccountCreatedActivity();

            }
        });



    }

    private void openAccountCreatedActivity() {

        Intent intent = new Intent(this, AccountCreatedActivity.class);
        intent.putExtra("username", user.username);
        intent.putExtra("email", user.email);
        intent.putExtra("password", user.password);

        startActivity(intent);
    }


}