package com.example.randomcardgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button cardButton;
    private String [] cardList;
    private Button reset;
    private Random generator;
    private TextView txt;
    private String cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newDeck();
        cardButton = findViewById(R.id.cardButton);
        reset = findViewById(R.id.reset);
        txt = findViewById(R.id.txtOutput);
        cards = "";
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateCard();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDeck();
                cards = "";
                txt.setText("Generate a Card");
            }
        });
    }

    public void generateCard(){
        if(!cards.isEmpty()){
            cards += ", ";
        }
        generator = new Random();
        int num = generator.nextInt(52);
        String temp = cardList [num];
        cards += temp;
        txt.setText(cards);
    }

    public void newDeck(){
        cardList = new String[52];
        cardList [0] = "AH";
        cardList [1] = "2H";
        cardList [2] = "3H";
        cardList [3] = "4H";
        cardList [4] = "5H";
        cardList [5] = "6H";
        cardList [6] = "7H";
        cardList [7] = "8H";
        cardList [8] = "9H";
        cardList [9] = "10H";
        cardList [10] = "JH";
        cardList [11] = "QH";
        cardList [12] = "KH";
        cardList [13] = "AS";
        cardList [14] = "2S";
        cardList [15] = "3S";
        cardList [16] = "4S";
        cardList [17] = "5S";
        cardList [18] = "6S";
        cardList [19] = "7S";
        cardList [20] = "8S";
        cardList [21] = "9S";
        cardList [22] = "10S";
        cardList [23] = "JS";
        cardList [24] = "QS";
        cardList [25] = "KS";
        cardList [26] = "AD";
        cardList [27] = "2D";
        cardList [28] = "3D";
        cardList [29] = "4D";
        cardList [30] = "5D";
        cardList [31] = "6D";
        cardList [32] = "7D";
        cardList [33] = "8D";
        cardList [34] = "9D";
        cardList [35] = "10D";
        cardList [36] = "JD";
        cardList [37] = "QD";
        cardList [38] = "KD";
        cardList [39] = "AC";
        cardList [40] = "2C";
        cardList [41] = "3C";
        cardList [42] = "4C";
        cardList [43] = "5C";
        cardList [44] = "6C";
        cardList [45] = "7C";
        cardList [46] = "8C";
        cardList [47] = "9C";
        cardList [48] = "10C";
        cardList [49] = "JC";
        cardList [50] = "QC";
        cardList [51] = "KC";
    }
}