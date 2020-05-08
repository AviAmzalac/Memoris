package com.example.memoris;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.memories.R;

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

    static ArrayList<TextView> List_button = new ArrayList<>();
    private int nb_error =0;
    static int right_answer = 0;
    private TextView text_1;
    private TextView text_2;
    private TextView text_3;

    private TextView text_4;
    private TextView text_5;
    private TextView text_6;

    private TextView text_7;
    private TextView text_8;
    private TextView text_9;

    private TextView text_10;
    private TextView text_11;
    private TextView text_12;
    private TextView error_text;

    private TextView indice_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.easy_user_interface);
        error_text = findViewById(R.id.error_counter);
        indice_text = findViewById(R.id.help);

        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        text_3 = findViewById(R.id.text_3);

        text_4 = findViewById(R.id.text_4);
        text_5 = findViewById(R.id.text_5);
        text_6 = findViewById(R.id.text_6);

        text_7 = findViewById(R.id.text_7);
        text_8 = findViewById(R.id.text_8);
        text_9 = findViewById(R.id.text_9);

        text_10 = findViewById(R.id.text_10);
        text_11 = findViewById(R.id.text_11);
        text_12 = findViewById(R.id.text_12);

        List_button.add(text_1);
        List_button.add(text_2);
        List_button.add(text_3);

        List_button.add(text_4);
        List_button.add(text_5);
        List_button.add(text_6);

        List_button.add(text_7);
        List_button.add(text_8);
        List_button.add(text_9);

        List_button.add(text_10);
        List_button.add(text_11);
        List_button.add(text_12);


        System.out.println("+++++++++++++++ LIST AFFICHE"+ Jeu.List_affiche);
        System.out.println("+++++++++++++++ LIST REP"+ Jeu.List_reponse);
        System.out.println("LISTE DES MAUVAISE REPONSE"+Jeu.List_mauvaises_reponses);

        afficher_list();

        for (int i = 0; i <= Jeu.List_affiche.size()-1; i++) {
            Integer text = Jeu.List_affiche.get(i);
            List_button.get(i).setText(getResources().getString(text));
        if(nb_error > 1){goto_resultspage();}
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

    public void goto_resultspage(){
        Intent intent = new Intent(Easy_User_Interface.this, Results_page.class);
        intent.putExtra("Ranswer", right_answer);
        intent.putExtra("Difficulty","EASY");
        startActivity(intent);
    }

    //////////////////////////////
    //lance la vérification sur le bouton choisi, et le fait disparaitre , si le choix est mauvais on enleve le mot de la liste de mauvaise reponse
    public void push_button(View view){

            switch (view.getId()) {
                case R.id.text_1:
                    text_1.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();

                    break;
                case R.id.text_2:
                    text_2.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_3:
                    text_3.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;

                case R.id.text_4:
                    text_4.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_5:
                    text_5.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_6:
                    text_6.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //   verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;

                case R.id.text_7:
                    text_7.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_8:
                    text_8.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //  verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_9:
                    text_9.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //   verification(view);
                   if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;

                case R.id.text_10:
                    text_10.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    // verification(view);
                   if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_11:
                    text_11.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    // verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();
                    break;
                case R.id.text_12:
                    text_12.setVisibility(View.INVISIBLE);recuperation_indice_mauvaise_rep(view);
                    //verification(view);
                    if(!verification(view)){Jeu.List_mauvaises_reponses.remove(recuperation_indice_mauvaise_rep(view));}else{;}afficher_list();

                    break;
                default:
                    break;
            }

    }
    // Verification qui permet de savoir si le mot choisis est correct ou non ,
    // si il est correct on retourne vrai
    // sinon on retourne faux et on augmente le nombre d'erreur de 1
    // si on arrive a la limite du nombre d'erreur acceptée on va sur la page de resultat
    public boolean verification(View view){
        int flag = 0;
        int i=0;

        TextView b = (TextView)view;
        String buttonText = b.getText().toString();
        System.out.println(" NOM DU TEXT DU BOUTON : "+buttonText);

        //        System.out.println(getResources().getString(text1));
        while(flag==0 && i < Jeu.List_reponse.size()){

            int text1 = Jeu.List_reponse.get(i);

            if(buttonText.equals(getResources().getString(text1))){
                System.out.println( getResources().getString(text1)+" OK");
                flag = 1;

                right_answer++;}
            else{

                System.out.println( getResources().getString(text1)+" Faux");}
                 i++;
           }
        if(flag ==1) {
            System.out.println("Nombre d'erreur: "+nb_error+"/3");
            if(right_answer == 6) goto_resultspage();

            return true;

        }else{ nb_error++;

            System.out.println("Nombre d'erreur: "+nb_error+"/3");
            error_text.setText(nb_error+"");
            if(nb_error >= 3){
                goto_resultspage();}

            return false;
        }
    }
    //Recuperation de l'indice du mot dans la liste_mauvaise reponse   ,
    public int recuperation_indice_mauvaise_rep(View view){
        int flag=1;
        int i=0;
        TextView b = (TextView)view;
        String buttonText = b.getText().toString();
            while(flag==1 && i< Jeu.List_mauvaises_reponses.size()){
                int text1 = Jeu.List_mauvaises_reponses.get(i);
                if(!(buttonText.equals(getResources().getString(text1)))){
                    i++;

                }else{ flag = 0; }

            }
        System.out.println("i = "+i+"  textbouton= "+buttonText+"  ");
        return i;
    }
    // Affichage de l'indice grace a un toast de courte durée
    public void indice_toast(View view){

        int text= Jeu.List_mauvaises_reponses.get(0);
        String indice = getResources().getString(text);
        Toast toast = Toast.makeText(Easy_User_Interface.this, getResources().getString(R.string.help)+indice, Toast.LENGTH_SHORT);
        View toastview = toast.getView();
        TextView tv = (TextView) toastview.findViewById(android.R.id.message);
        tv.setTextSize(21);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.toast, 0, 0, 0);
        tv.setCompoundDrawablePadding(15);
        toastview.setBackgroundColor(Color.parseColor( "#000000"));
        toast.show();
    }
    // Permet d'afficher les differentes listes   ( aide pour la programmation )
    public void afficher_list(){
        //liste mots
        System.out.print("liste mot: ");
        for(int i = 0; i< Jeu.List_affiche.size(); i++){
            int text1 = Jeu.List_affiche.get(i);

            System.out.print( getResources().getString(text1)+", ");
        }
        //bonnes reponses
        System.out.println("-");
        System.out.print("bonne_rep: ");
        for(int j = 0; j< Jeu.List_reponse.size(); j++){
            int text2 = Jeu.List_reponse.get(j);
            System.out.print(getResources().getString(text2)+", ");
        }
        System.out.println("-");
        //mauvaises reponses
        System.out.print("mauvaises_rep: ");
        for(int j = 0; j< Jeu.List_mauvaises_reponses.size(); j++){
            int text2 = Jeu.List_mauvaises_reponses.get(j);
            System.out.print(getResources().getString(text2)+", ");
        }
        System.out.println("-");
    }
    public void onBackPressed() {
        Intent gameActivity = new Intent(Easy_User_Interface.this, MainActivity.class);
        startActivity(gameActivity);
    }

}