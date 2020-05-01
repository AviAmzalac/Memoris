package com.example.memoris;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memories.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HomeWatcher mHomeWatcher;
    private boolean mIsBound = false;
    private Music_Background mServ;
    private ImageButton SoundOn, SoundOff;
    private MyDbAdapter myDatabase;

    private ServiceConnection Scon = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServ = ((Music_Background.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, Music_Background.class), Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
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
        myDatabase = new MyDbAdapter(this);
        myDatabase.open();
        ArrayList<Score> mes_scores = myDatabase.getAllScore();
        for (int i = 0; i < mes_scores.size(); i++) {
            System.out.println(mes_scores.get(i).getNb_answers());
            System.out.println(mes_scores.get(i).getDifficulty());
            System.out.println(mes_scores.get(i).getId());
        }

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
            }
        });

        SoundOff.setOnClickListener(new View.OnClickListener() { //si soundOff est click
            @Override
            public void onClick(View v) {
                doUnbindService();
                stopService(music);
                SoundOn.setVisibility(View.VISIBLE);
                SoundOff.setVisibility(View.INVISIBLE);
            }
        });


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
        myDatabase.close();
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

    public void goto_leaderboard(View view) {
        Intent gameActivity = new Intent(MainActivity.this, Leaderboard.class);
        startActivity(gameActivity);
    }

    public void erase_data(View view) {
        myDatabase.insert_score("NIGHTMARE", 2);
        if (myDatabase.countEvent() > 0) {
            myDatabase.deleteTable();
        } else {
            Toast.makeText(MainActivity.this, "Le leaderboard est déjà vide", Toast.LENGTH_SHORT).show();
        }


    }
    public void onBackPressed() {
        // do nothing.
    }
}
