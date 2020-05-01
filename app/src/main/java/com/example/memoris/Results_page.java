package com.example.memoris;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memories.R;

public class Results_page extends AppCompatActivity {

    //GESTION MUSIC
    HomeWatcher mHomeWatcher;
    private boolean mIsBound = false;
    private Music_Background mServ;
    private TextView scoreLabel;
    private MyDbAdapter myDatabase;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_page);
        TextView scoreLabel =  findViewById(R.id.scoreLabel);

        Intent intent = getIntent();
        int scoreRecup = intent.getIntExtra("Ranswer",0);
        String difficultyRecup = intent.getStringExtra("Difficulty");
        scoreLabel.setText(scoreRecup+" ");
        myDatabase = new MyDbAdapter(this);
        myDatabase.open();
        myDatabase.insert_score(difficultyRecup, scoreRecup);
        myDatabase.close();




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
    public void goto_difficulty_page(View view) {
        Intent gameActivity = new Intent(Results_page.this, Difficulty_page.class);
        startActivity(gameActivity);
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

    public void goto_main(View view){
        Intent gameActivity = new Intent(Results_page.this, MainActivity.class);
        startActivity(gameActivity);
    }
    public void onBackPressed() {
        Intent gameActivity = new Intent(Results_page.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
