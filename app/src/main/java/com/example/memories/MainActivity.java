package com.example.memories;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    HomeWatcher mHomeWatcher;
    private boolean mIsBound = false;
    private Music_Background mServ;
    private ImageButton SoundOn, SoundOff;

    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServ = ((Music_Background.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this, Music_Background.class), Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if(mIsBound) {
            unbindService(Scon);
            mIsBound = false;
        }
    }
    //////////////////////////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SoundOff = findViewById(R.id.imageButtonSoundOff);
        SoundOn = findViewById(R.id.imageButtonSoundOn);

        //BIND MUSIC SERVICES
        doBindService();
        final Intent music = new Intent();
        music.setClass(this, Music_Background.class);

        SoundOn.setOnClickListener(new View.OnClickListener() { //si soundOn est click
            @Override
            public void onClick(View v) {
                startService(music);
                SoundOn.setVisibility(View.INVISIBLE);
                SoundOff.setVisibility(View.VISIBLE);
            }});

        SoundOff.setOnClickListener(new View.OnClickListener() { //si soundOff est click
            @Override
            public void onClick(View v) {
                doUnbindService();
                stopService(music);
                SoundOn.setVisibility(View.VISIBLE);
                SoundOff.setVisibility(View.INVISIBLE);
            }});


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

    public void goto_difficulty_page(View view) {
        Intent gameActivity = new Intent(MainActivity.this, Difficulty_page.class);
        startActivity(gameActivity);
    }

}
