package com.example.memoris;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.memories.R;

public class Timer_page extends AppCompatActivity implements View.OnClickListener {

    //GESTION MUSIC
    HomeWatcher mHomeWatcher;
    private boolean mIsBound = false;
    private Music_Background mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServ = ((Music_Background.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doUnbindService() {
        if(mIsBound) {
            unbindService(Scon);
            mIsBound = false;
        }
    }
    //////////////////////////////////////////////////////////////////

    private Button btnrdy;
    private TextView countdown;

    CountDownTimer countDownTimer = new CountDownTimer(4 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            countdown.setText("" + millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            Intent gameActivity = new Intent(Timer_page.this, Jeu.class);
            startActivity(gameActivity);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_page);
        btnrdy = findViewById(R.id.btnrdy);
        btnrdy.setOnClickListener(this);
        countdown = findViewById(R.id.countdown);


        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mServ != null) {
            mServ.resumeMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, Music_Background.class);
        stopService(music);

    }

    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }
    }

    @Override
    public void onClick(View v){
        btnrdy.setVisibility(View.INVISIBLE);
        countDownTimer.start();
    }

}






