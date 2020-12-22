package com.example.logindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.logindemo.MESSAGE";
    private EditText email, password;
    private Button submit;
    private MutableLiveData<EditText> data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.email = (EditText)findViewById(R.id.emailAddress);
        this.password = (EditText)findViewById(R.id.password);
        this.submit = (Button)findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validateEmailForm(email.getText().toString());
                validatePasswordForm(password.getText().toString());
            }
        });
    }

    private void validatePasswordForm(String toString) {

    }

    private void validateEmailForm(String toString) {

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SampleDashboard.class);
        intent.putExtra(EXTRA_MESSAGE, email.getText().toString());
        startActivity(intent);
    }
}