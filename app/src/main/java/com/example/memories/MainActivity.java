package com.example.memories;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goto_difficulty_page(View view) {
        Intent gameActivity = new Intent(MainActivity.this, difficulty_page.class);
        startActivity(gameActivity);
    }
    public void goto_setting(View view) {
        Intent gameActivity = new Intent(MainActivity.this, setting.class);
        startActivity(gameActivity);
    }
}
