package com.example.memories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
<<<<<<< HEAD

    public void goto_timer_page(View view){
        Intent gameActivity = new Intent(difficulty_page.this, timer_page.class);
        startActivity(gameActivity);
    }
=======
>>>>>>> d77bac1d5bae5f60c8260a737aed7e1204f7e34f
}
