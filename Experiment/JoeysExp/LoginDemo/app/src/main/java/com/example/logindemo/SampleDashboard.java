package com.example.logindemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SampleDashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_dashboard);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        String message = "You son of a Bitch";

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.potato);
        textView.setText(String.format("Welcome %s!", message));
    }
}