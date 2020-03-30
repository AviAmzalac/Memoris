package com.example.memories;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class timer_page extends AppCompatActivity {

    private Button btnrdy;
    private TextView countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_page);
        btnrdy = findViewById(R.id.btnrdy);
        countdown = findViewById(R.id.countdown);
    }

    public void make_btnrdy_disappear(View view) {
         btnrdy.setVisibility(View.INVISIBLE);
    }

    public void start_countdown(View view) throws InterruptedException {
        countdown.setText("3");
        wait(1000);
        countdown.setText("2");
        wait(1000);
        countdown.setText("1");
        wait(1000);
        countdown.setText("");
    }
}





