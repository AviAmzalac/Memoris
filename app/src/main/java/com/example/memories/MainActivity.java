package com.example.memories;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void page2(View view){
        Intent gameActivity = new Intent(MainActivity.this, jeu.class);
        startActivity(gameActivity);

    }
}
