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

        //------------------------------------------------------------------

        ArrayList<Integer> List_Slider_BasedOn_reponse = new ArrayList<>();
        for (int i=0;i<6;i++){
            List_Slider_BasedOn_reponse.add(Integer.parseInt(Easy_User_Interface.list_rep.get(i)));
        }


        //------------------------------------------------------------------

        viewPager2 = findViewById(R.id.viewPagerImageSliderEasy);
        viewPager2.setUserInputEnabled(false);
        final List<SliderItem> sliderItems = new ArrayList<>();
        for (int i=0;i<Easy_User_Interface.list_rep.size();i++) {
            sliderItems.add(new SliderItem(List_Slider_BasedOn_reponse.get(i)));
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