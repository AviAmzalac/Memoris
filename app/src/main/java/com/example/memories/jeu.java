package com.example.memories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class jeu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(jeu.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
