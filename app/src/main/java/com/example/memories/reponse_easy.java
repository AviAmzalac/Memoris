package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class reponse_easy extends AppCompatActivity {

    private Button button_1;
    private Button button_2;
    private Button button_3;

    private Button button_4;
    private Button button_5;
    private Button button_6;

    private Button button_7;
    private Button button_8;
    private Button button_9;

    private Button button_10;
    private Button button_11;
    private Button button_12;


    private int nb_mot_affiche=12;
    private int nb_reponse=6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reponse_easy);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);

        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);

        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        button_10 = findViewById(R.id.button_10);
        button_11 = findViewById(R.id.button_11);
        button_12 = findViewById(R.id.button_12);

        // CREATION LISTE DES MOTS DU JEU ( A COMPLETER A CHAQUE AJOUT DE MOT)
            ArrayList<String> List_mot = new ArrayList<String>();
            List_mot.add("apple");
            List_mot.add("balloon");
            List_mot.add("banana");
            List_mot.add("bell pepper");
            List_mot.add("bicycle");
            List_mot.add("bird");

            List_mot.add("butterfly");
            List_mot.add("cabbage");
            List_mot.add("camera");
            List_mot.add("car");
            List_mot.add("carrot");

            List_mot.add("cat");
            List_mot.add("cherry");
            List_mot.add("coffee");
            List_mot.add("dice");
            List_mot.add("dog");

            List_mot.add("elephant");
            List_mot.add("hammer");
            List_mot.add("hat");
            List_mot.add("ice cream");
            List_mot.add("juice");

            List_mot.add("key");
            List_mot.add("laptop");
            List_mot.add("lemon");
            List_mot.add("orange");
            List_mot.add("paintbrush");

            List_mot.add("panda");
            List_mot.add("pencil");
            List_mot.add("popcorn");
            List_mot.add("present");
            List_mot.add("screw");

            List_mot.add("shark");
            List_mot.add("sheep");
            List_mot.add("smartphone");
            List_mot.add("strawberry");
            List_mot.add("sun");

            List_mot.add("tiger");
            List_mot.add("watermelon");
            List_mot.add("whale");

        // LISTE DES MOTS AFFICHES POUR LE JOUEUR ---------------------------------------------------------------------------
        ArrayList<String> List_affiche = new ArrayList<String>();
        int x;
        for(int i=0;i<=nb_mot_affiche;i++){
            do{ x=(int)(Math.random()*(List_mot.size()-1+1)+0);}
            while(List_affiche.contains(List_mot.get(x)));
            List_affiche.add(List_mot.get(x));
        }

        // LISTE DES REPONSES --------------------------------------------------------------------------------------------------
        ArrayList<String> List_reponse = new ArrayList<String>();
        for(int i=0;i<=nb_reponse;i++){
            do{ x=(int)(Math.random()*(List_affiche.size()-1+1)+0);}
            while(List_reponse.contains(List_affiche.get(x)));
            List_reponse.add(List_affiche.get(x));

        }

        ArrayList<Button> List_button = new ArrayList<Button>();
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

        for (int i = 0; i < List_affiche.size()-1; i++) {
            String text = List_affiche.get(i);
            if (text.equals(getResources().getString(R.string.apple))) {
                List_button.get(i).setText(getResources().getString(R.string.apple));
            }
            else if (text.equals(getResources().getString(R.string.balloon))) {
                List_button.get(i).setText(getResources().getString(R.string.balloon));
            }

            else if (text.equals(getResources().getString(R.string.banana))) {
                List_button.get(i).setText(getResources().getString(R.string.banana));
            }
            else if (text.equals(getResources().getString(R.string.bellpepper))) {
                List_button.get(i).setText(getResources().getString(R.string.bellpepper));
            }
            else if (text.equals(getResources().getString(R.string.bicycle))) {
                List_button.get(i).setText(getResources().getString(R.string.bicycle));
            }
            else if (text.equals(getResources().getString(R.string.bird))) {
                List_button.get(i).setText(getResources().getString(R.string.bird));
            }
            else if (text.equals(getResources().getString(R.string.butterfly))) {
                List_button.get(i).setText(getResources().getString(R.string.butterfly));
            }
            else if (text.equals(getResources().getString(R.string.cabbage))) {
                List_button.get(i).setText(getResources().getString(R.string.cabbage));
            }
            else if (text.equals(getResources().getString(R.string.camera))) {
                List_button.get(i).setText(getResources().getString(R.string.camera));
            }
            else if (text.equals(getResources().getString(R.string.car))) {
                List_button.get(i).setText(getResources().getString(R.string.car));
            }
            else if (text.equals(getResources().getString(R.string.carrot))) {
                List_button.get(i).setText(getResources().getString(R.string.carrot));
            }
            else if (text.equals(getResources().getString(R.string.cat))) {
                List_button.get(i).setText(getResources().getString(R.string.cat));
            }
            else if (text.equals(getResources().getString(R.string.cherry))) {
                List_button.get(i).setText(getResources().getString(R.string.cherry));
            }
            else if (text.equals(getResources().getString(R.string.coffee))) {
                List_button.get(i).setText(getResources().getString(R.string.coffee));
            }
            else if (text.equals(getResources().getString(R.string.dice))) {
                List_button.get(i).setText(getResources().getString(R.string.dice));
            }
            else if (text.equals(getResources().getString(R.string.dog))) {
                List_button.get(i).setText(getResources().getString(R.string.dog));
            }
            else if (text.equals(getResources().getString(R.string.elephant))) {
                List_button.get(i).setText(getResources().getString(R.string.elephant));
            }
            else if (text.equals(getResources().getString(R.string.hammer))) {
                List_button.get(i).setText(getResources().getString(R.string.hammer));
            }

            else if (text.equals(getResources().getString(R.string.hat))) {
                List_button.get(i).setText(getResources().getString(R.string.hat));
            }
            else if (text.equals(getResources().getString(R.string.icecream))) {
                List_button.get(i).setText(getResources().getString(R.string.icecream));
            }
            else if (text.equals(getResources().getString(R.string.juice))) {
                List_button.get(i).setText(getResources().getString(R.string.juice));
            }
            else if (text.equals(getResources().getString(R.string.key))) {
                List_button.get(i).setText(getResources().getString(R.string.key));
            }
            else if (text.equals(getResources().getString(R.string.laptop))) {
                List_button.get(i).setText(getResources().getString(R.string.laptop));
            }
            else if (text.equals(getResources().getString(R.string.lemon))) {
                List_button.get(i).setText(getResources().getString(R.string.lemon));
            }
            else if (text.equals(getResources().getString(R.string.orange))) {
                List_button.get(i).setText(getResources().getString(R.string.orange));
            }
            else if (text.equals(getResources().getString(R.string.paintbrush))) {
                List_button.get(i).setText(getResources().getString(R.string.paintbrush));
            }
            else if (text.equals(getResources().getString(R.string.panda))) {
                List_button.get(i).setText(getResources().getString(R.string.panda));
            }
            else if (text.equals(getResources().getString(R.string.pencil))) {
                List_button.get(i).setText(getResources().getString(R.string.pencil));
            }
            else if (text.equals(getResources().getString(R.string.popcorn))) {
                List_button.get(i).setText(getResources().getString(R.string.popcorn));
            }
            else if (text.equals(getResources().getString(R.string.present))) {
                List_button.get(i).setText(getResources().getString(R.string.present));
            }
            else if (text.equals(getResources().getString(R.string.screw))) {
                List_button.get(i).setText(getResources().getString(R.string.screw));
            }
            else if (text.equals(getResources().getString(R.string.shark))) {
                List_button.get(i).setText(getResources().getString(R.string.shark));
            }
            else if (text.equals(getResources().getString(R.string.sheep))) {
                List_button.get(i).setText(getResources().getString(R.string.sheep));
            }
            else if (text.equals(getResources().getString(R.string.smartphone))) {
                List_button.get(i).setText(getResources().getString(R.string.smartphone));
            }
            else if (text.equals(getResources().getString(R.string.strawberry))) {
                List_button.get(i).setText(getResources().getString(R.string.strawberry));
            }
            else if (text.equals(getResources().getString(R.string.sun))) {
                List_button.get(i).setText(getResources().getString(R.string.sun));
            }
            else if (text.equals(getResources().getString(R.string.tiger))) {
                List_button.get(i).setText(getResources().getString(R.string.tiger));
            }
            else if (text.equals(getResources().getString(R.string.watermelon))) {
                List_button.get(i).setText(getResources().getString(R.string.watermelon));
            }
            else if (text.equals(getResources().getString(R.string.whale))) {
                List_button.get(i).setText(getResources().getString(R.string.whale));
            }
        }
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(reponse_easy.this, MainActivity.class);
        startActivity(gameActivity);
    }

}