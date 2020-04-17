package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Easy_User_Interface extends AppCompatActivity {

    static ArrayList<Integer> list_rep = new ArrayList<>();
    static int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.easy_user_interface);

        setContentView(R.layout.reponse_easy);
        Button button_1 = findViewById(R.id.button_1);
        Button button_2 = findViewById(R.id.button_2);
        Button button_3 = findViewById(R.id.button_3);

        Button button_4 = findViewById(R.id.button_4);
        Button button_5 = findViewById(R.id.button_5);
        Button button_6 = findViewById(R.id.button_6);

        Button button_7 = findViewById(R.id.button_7);
        Button button_8 = findViewById(R.id.button_8);
        Button button_9 = findViewById(R.id.button_9);

        Button button_10 = findViewById(R.id.button_10);
        Button button_11 = findViewById(R.id.button_11);
        Button button_12 = findViewById(R.id.button_12);

        ArrayList<Button> List_button = new ArrayList<>();
        List_button.add(button_1);
        List_button.add(button_2);
        List_button.add(button_3);

        List_button.add(button_4);
        List_button.add(button_5);
        List_button.add(button_6);

        List_button.add(button_7);
        List_button.add(button_8);
        List_button.add(button_9);

        List_button.add(button_10);
        List_button.add(button_11);
        List_button.add(button_12);

        System.out.println("+++++++++++++++"+Jeu.List_affiche);
        for (int i = 0; i < Jeu.List_affiche.size()-1; i++) {
            Integer text = Jeu.List_affiche.get(i);
            List_button.get(i).setText(getResources().getString(text));
        }
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(Easy_User_Interface.this, MainActivity.class);

        startActivity(gameActivity);
    }

    public void goto_leaderboard(View view){
        Intent intent = new Intent(getApplicationContext(), Results_page.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

    //////////////////////////////
    public void addFakeScore(View view) {
        score+=1;
    }
}