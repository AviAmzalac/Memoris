package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class reponse_easy extends AppCompatActivity {

    private Button button_1;
    private Button button_2;
    private Button button_3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reponse_easy);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);


        ArrayList<String> List_reponse = new ArrayList<String>();
        List_reponse.add("dog");
        List_reponse.add("sun");

        ArrayList<String> List_mot = new ArrayList<String>();
        List_mot.add("dog");
        List_mot.add("coffee");
        List_mot.add("apple");

        ArrayList<Button> List_button = new ArrayList<Button>();
        List_button.add(button_1);
        List_button.add(button_2);
        List_button.add(button_3);

        for (int i = 0; i < List_mot.size(); i++) {
            String text = List_mot.get(i);
            if (text.equals(getResources().getString(R.string.dog))) {
                List_button.get(i).setText(getResources().getString(R.string.dog));
            }

            else if (text.equals(getResources().getString(R.string.coffee))) {
                List_button.get(i).setText(getResources().getString(R.string.coffee));
            }

            else if (text.equals(getResources().getString(R.string.apple))) {
                List_button.get(i).setText(getResources().getString(R.string.apple));
            }
        }
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(reponse_easy.this, MainActivity.class);
        startActivity(gameActivity);
    }
}