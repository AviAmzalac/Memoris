package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
    }

    public void goto_main(View view){
        Intent gameActivity = new Intent(setting.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
