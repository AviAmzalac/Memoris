package com.example.memories;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class jeu extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        viewPager2 = findViewById(R.id.viewPagerImageSliderEasy);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.shark));
        sliderItems.add(new SliderItem(R.drawable.apple));
        sliderItems.add(new SliderItem(R.drawable.butterfly));
        sliderItems.add(new SliderItem(R.drawable.dog));
        sliderItems.add(new SliderItem(R.drawable.whale));
        sliderItems.add(new SliderItem(R.drawable.sheep));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
    }
}