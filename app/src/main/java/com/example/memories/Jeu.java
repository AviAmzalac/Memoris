package com.example.memories;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class Jeu extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    static ArrayList<Integer> list_rep = new ArrayList<>();
    static ArrayList<Integer> List_affiche = new ArrayList<>();


    //---------------------------------------------------------------------------------------------
    //timer pour passer a la page suivante
    CountDownTimer timer_to_next = new CountDownTimer(1000, 1000) {
    //Override des méthodes
        @Override
        public void onTick(long l) {
        }

        @Override
        public void onFinish() {
            Intent gameActivity = new Intent(Jeu.this, Easy_User_Interface.class);
            startActivity(gameActivity);
        }
    };

    //---------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);


        //------------------------------------------------------------------

        viewPager2 = findViewById(R.id.viewPagerImageSliderEasy);
        viewPager2.setUserInputEnabled(false);

        // CREATION LISTE DES MOTS DU JEU ( A COMPLETER A CHAQUE AJOUT DE MOT)
        ArrayList<Integer> List_mot = new ArrayList<>();
        List_mot.add(R.string.apple);
        List_mot.add(R.string.balloon);
        List_mot.add(R.string.banana);
        List_mot.add(R.string.bellpepper);
        List_mot.add(R.string.bicycle);
        List_mot.add(R.string.bird);
        List_mot.add(R.string.butterfly);
        List_mot.add(R.string.cabbage);
        List_mot.add(R.string.camera);
        List_mot.add(R.string.car);
        List_mot.add(R.string.carrot);
        List_mot.add(R.string.cat);
        List_mot.add(R.string.cherry);
        List_mot.add(R.string.coffee);
        List_mot.add(R.string.dice);
        List_mot.add(R.string.dog);
        List_mot.add(R.string.elephant);
        List_mot.add(R.string.hammer);
        List_mot.add(R.string.hat);
        List_mot.add(R.string.icecream);
        List_mot.add(R.string.juice);
        List_mot.add(R.string.key);
        List_mot.add(R.string.laptop);
        List_mot.add(R.string.lemon);
        List_mot.add(R.string.orange);
        List_mot.add(R.string.paintbrush);
        List_mot.add(R.string.panda);
        List_mot.add(R.string.pencil);
        List_mot.add(R.string.popcorn);
        List_mot.add(R.string.present);
        List_mot.add(R.string.screw);
        List_mot.add(R.string.shark);
        List_mot.add(R.string.sheep);
        List_mot.add(R.string.smartphone);
        List_mot.add(R.string.strawberry);
        List_mot.add(R.string.sun);
        List_mot.add(R.string.tiger);
        List_mot.add(R.string.watermelon);
        List_mot.add(R.string.whale);
        // CREATION LISTE DES IMAGES ( A COMPLETER A CHAQUE AJOUT D'IMAGE)
        ArrayList<Integer> List_Items = new ArrayList<>();
        List_Items.add(R.drawable.apple);
        List_Items.add(R.drawable.balloon);
        List_Items.add(R.drawable.banana);
        List_Items.add(R.drawable.bellpepper);
        List_Items.add(R.drawable.bicycle);
        List_Items.add(R.drawable.bird);
        List_Items.add(R.drawable.butterfly);
        List_Items.add(R.drawable.cabbage);
        List_Items.add(R.drawable.camera);
        List_Items.add(R.drawable.car);
        List_Items.add(R.drawable.carrot);
        List_Items.add(R.drawable.cat);
        List_Items.add(R.drawable.cherry);
        List_Items.add(R.drawable.coffee);
        List_Items.add(R.drawable.dice);
        List_Items.add(R.drawable.dog);
        List_Items.add(R.drawable.elephant);
        List_Items.add(R.drawable.hammer);
        List_Items.add(R.drawable.hat);
        List_Items.add(R.drawable.icecream);
        List_Items.add(R.drawable.juice);
        List_Items.add(R.drawable.key);
        List_Items.add(R.drawable.laptop);
        List_Items.add(R.drawable.lemon);
        List_Items.add(R.drawable.orange);
        List_Items.add(R.drawable.paintbrush);
        List_Items.add(R.drawable.panda);
        List_Items.add(R.drawable.pencil);
        List_Items.add(R.drawable.popcorn);
        List_Items.add(R.drawable.present);
        List_Items.add(R.drawable.screw);
        List_Items.add(R.drawable.shark);
        List_Items.add(R.drawable.sheep);
        List_Items.add(R.drawable.smartphone);
        List_Items.add(R.drawable.strawberry);
        List_Items.add(R.drawable.sun);
        List_Items.add(R.drawable.tiger);
        List_Items.add(R.drawable.watermelon);
        List_Items.add(R.drawable.whale);

        // LISTE DES MOTS AFFICHES POUR LE JOUEUR ---------------------------------------------------------------------------
        ArrayList<Integer> List_affiche_image = new ArrayList<>();
        int x;
        int nb_mot_affiche = 12;
        for(int i = 0; i<= nb_mot_affiche; i++){
            do{ x=(int)(Math.random()*(List_mot.size()-1+1)+0);}
            while(List_affiche.contains(List_mot.get(x)));
            List_affiche.add(List_mot.get(x));
            List_affiche_image.add((List_Items.get(x)));
        }

        // LISTE DES REPONSES --------------------------------------------------------------------------------------------------
        ArrayList<Integer> List_reponse = new ArrayList<>();
        int nb_reponse = 6;
        for(int i = 0; i<= nb_reponse; i++){
            do{ x=(int)(Math.random()*(List_affiche.size()-1+1)+0);}
            while(List_reponse.contains(List_affiche.get(x)));
            List_reponse.add(List_affiche.get(x));
            list_rep.add(List_affiche_image.get(x));
        }

        final List<SliderItem> sliderItems = new ArrayList<>();
        for (int i=0;i<6;i++) {
            sliderItems.add(new SliderItem(list_rep.get(i)));
        }


        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 1500); //Durée pour chaque
            }
        });
    }

    //---------------------------------------------------------------------------------------------
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            if(viewPager2.getCurrentItem() == 5){
                timer_to_next.start();
            }
        }
    };

    //---------------------------------------------------------------------------------------------

    @Override
    protected void onPause() { //gestion de la pause
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() { //gestion de la reprise
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

}