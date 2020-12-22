package com.cs309.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnJson, btnString, btnSubmit;
    private EditText inUsername, inPassword, inEmail;
    private boolean flag1,flag2,flag3 = false;
    private String username,password,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find username text
        inUsername = (EditText) findViewById(R.id.inUsername);
        inPassword = (EditText) findViewById(R.id.inPassword);
        inEmail = (EditText) findViewById(R.id.inEmail);

        inUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    flag1 = true;
                   if(flag1&&flag2&&flag3) btnSubmit.setEnabled(true);
                } else {
                    btnSubmit.setEnabled(false);
                }
            }
        });

        inPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    flag2 = true;
                    if(flag1&&flag2&&flag3) btnSubmit.setEnabled(true);
                } else {
                    btnSubmit.setEnabled(false);
                }
            }
        });

        inEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    flag3 = true;
                    if(flag1&&flag2&&flag3) btnSubmit.setEnabled(true);
                } else {
                    btnSubmit.setEnabled(false);
                }
            }
        });

        // Find buttons
        btnString = (Button) findViewById(R.id.btnStringRequest);
        btnJson = (Button) findViewById(R.id.btnJsonRequest);
        btnSubmit = (Button) findViewById(R.id.btnSubmitUserInfo);


        // button click listeners
        btnString.setOnClickListener(this);
        btnJson.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmitUserInfo:
                username = inUsername.getText().toString();
                password = inPassword.getText().toString();
                email = inEmail.getText().toString();
                btnString.setEnabled(true);
                btnJson.setEnabled(true);
                break;
            case R.id.btnStringRequest:
                Intent i = new Intent(MainActivity.this,
                        StringRequestActivity.class);
                i.putExtra("username",username);
                startActivity(i);
                break;
            case R.id.btnJsonRequest:
                Intent j = new Intent(MainActivity.this,
                        JsonRequestActivity.class);
                j.putExtra("username",username);
                j.putExtra("password",password);
                j.putExtra("email",email);
                startActivity(j);
                break;
            default:
                break;
        }
    }
}
