package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;



public class Difficulty_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_page);
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(Difficulty_page.this, MainActivity.class);
        startActivity(gameActivity);
    }

    public void goto_timer_page(View view){
        Intent gameActivity = new Intent(Difficulty_page.this, Timer_page.class);
        startActivity(gameActivity);
    }

}
