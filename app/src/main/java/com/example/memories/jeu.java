package com.example.memories;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class jeu extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    //---------------------------------------------------------------------------------------------
    //timer pour passer a la page suivante
    CountDownTimer timer_to_next = new CountDownTimer(1 * 1000, 1000) {
    //Override des méthodes
        @Override
        public void onTick(long l) {
        }

        @Override
        public void onFinish() {
            Intent gameActivity = new Intent(jeu.this, reponse_easy.class);
            startActivity(gameActivity);
        }
    };

    //---------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        viewPager2 = findViewById(R.id.viewPagerImageSliderEasy);
        viewPager2.setUserInputEnabled(false);
        final List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.shark));
        sliderItems.add(new SliderItem(R.drawable.apple));
        sliderItems.add(new SliderItem(R.drawable.butterfly));
        sliderItems.add(new SliderItem(R.drawable.dog));
        sliderItems.add(new SliderItem(R.drawable.whale));
        sliderItems.add(new SliderItem(R.drawable.sheep));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 1500); //Durée pour chaque
                System.out.println(viewPager2.getCurrentItem());
                System.out.println(viewPager2.getCurrentItem());
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