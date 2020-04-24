package com.example.memories;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Easy_User_Interface extends AppCompatActivity {

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

    static ArrayList<Button> List_button = new ArrayList<>();
    static int score;
    private int nb_error =0;
    static int right_answer = 0;
    private Button button_1;
    private Button button_2;
    private Button button_3;

    private Button button_4;
    private Button button_5;
    private Button button_6;

    private Button button_7;
    private Button button_8;
    private Button button_9;

    private Button button_10;
    private Button button_11;
    private Button button_12;
    private TextView error_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.easy_user_interface);
        error_text = findViewById(R.id.error_counter);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);

        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);

        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        button_10 = findViewById(R.id.button_10);
        button_11 = findViewById(R.id.button_11);
        button_12 = findViewById(R.id.button_12);

        List_button.add(button_1);
        List_button.add(button_2);
        List_button.add(button_3);

        List_button.add(button_4);
        List_button.add(button_5);
        List_button.add(button_6);

        List_button.add(button_7);
        List_button.add(button_8);
        List_button.add(button_9);

        List_button.add(button_10);
        List_button.add(button_11);
        List_button.add(button_12);


        System.out.println("+++++++++++++++ LIST AFFICHE"+Jeu.List_affiche);
        System.out.println("+++++++++++++++ LIST REP"+Jeu.List_reponse);
        Integer text1 = Jeu.List_affiche.get(0);
        System.out.println(getResources().getString(text1));
        afficher_list();

        for (int i = 0; i <= Jeu.List_affiche.size()-1; i++) {
            Integer text = Jeu.List_affiche.get(i);
            List_button.get(i).setText(getResources().getString(text));

        }

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
///////////////////////////////////////////// FIN ONCREATE
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
        Intent gameActivity = new Intent(Easy_User_Interface.this, MainActivity.class);

        startActivity(gameActivity);
    }

    public void goto_leaderboard(){
        Intent intent = new Intent(Easy_User_Interface.this, Results_page.class);
        intent.putExtra("Ranswer", right_answer);
        intent.putExtra("Difficulty","Easy");
        startActivity(intent);
    }

    //////////////////////////////
    public void addFakeScore(View view) {
        score+=1;
    }
    //////////////////////////////
    public void push_button(View view){

            switch (view.getId()) {
                case R.id.button_1:
                    button_1.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_2:
                    button_2.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_3:
                    button_3.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;

                case R.id.button_4:
                    button_4.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_5:
                    button_5.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_6:
                    button_6.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;

                case R.id.button_7:
                    button_7.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_8:
                    button_8.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_9:
                    button_9.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;

                case R.id.button_10:
                    button_10.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_11:
                    button_11.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                case R.id.button_12:
                    button_12.setVisibility(View.INVISIBLE);
                    verification(view);
                    break;
                default:
                    break;
            }

    }
    public boolean verification(View view){
        int flag = 0;
        int i=0;

        Button b = (Button)view;
        String buttonText = b.getText().toString();
        System.out.println(" NOM DU TEXT DU BUTOTN : "+buttonText);

        //        System.out.println(getResources().getString(text1));
        while(flag==0 && i < Jeu.List_reponse.size()){
            int text1 = Jeu.List_reponse.get(i);

            if(buttonText.equals(getResources().getString(text1))){
                System.out.println( getResources().getString(text1)+" OK");
                flag = 1;
                right_answer++;
            } else{

                System.out.println( getResources().getString(text1)+" Faux");}
                 i++;


           }
        if(flag ==1) {
            System.out.println("Nombre d'erreur: "+nb_error+"/3");
            if(right_answer == 6) goto_leaderboard();
            return true;
        }else{ nb_error++;
            System.out.println("Nombre d'erreur: "+nb_error+"/3");
            error_text.setText(nb_error+"");
            if(nb_error >= 3){goto_leaderboard();}

            return false;
        }
    }
    public void afficher_list(){
        for(int i = 0; i< Jeu.List_affiche.size();i++){
            int text1 = Jeu.List_affiche.get(i);

            System.out.print( getResources().getString(text1)+", ");
        }
        System.out.println("-");
        for(int j = 0; j< Jeu.List_reponse.size();j++){
            int text2 = Jeu.List_reponse.get(j);
            System.out.print( getResources().getString(text2)+", ");
        }
        System.out.println("-");
    }
}