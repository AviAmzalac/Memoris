package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;



public class difficulty_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_page);
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(difficulty_page.this, MainActivity.class);
        startActivity(gameActivity);
    }

    public void goto_timer_page(View view){
        Intent gameActivity = new Intent(difficulty_page.this, timer_page.class);
        startActivity(gameActivity);
    }

}
