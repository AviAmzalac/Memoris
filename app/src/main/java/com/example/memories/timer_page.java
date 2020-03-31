package com.example.memories;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class timer_page extends AppCompatActivity implements View.OnClickListener {

    private Button btnrdy;
    private TextView countdown;

    CountDownTimer countDownTimer = new CountDownTimer(4 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            countdown.setText("" + millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_page);
        btnrdy = findViewById(R.id.btnrdy);
        btnrdy.setOnClickListener(this);
        countdown = findViewById(R.id.countdown);
    }

    @Override
    public void onClick(View v){
        btnrdy.setVisibility(View.INVISIBLE);
        countDownTimer.start();
    }
}






