package com.example.memories;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Score> {

    private final Context context;

    public MyArrayAdapter(Context context, Score[] values) {
        super(context, R.layout.cell_score, values);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
// Gestion optimisée de la mémoire (réutilisation de cellules):
        View cellView = convertView;
        if (cellView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.cell_score, parent, false);
        }
        TextView essai_champ = (TextView) cellView.findViewById(R.id.essai_label);
        TextView difficulty_champ = (TextView) cellView.findViewById(R.id.difficulty_label);
        TextView nbrep_champ = (TextView) cellView.findViewById(R.id.nb_rep);
        Score score = getItem(position);
        essai_champ.setText(Integer.toString(score.getId()));
        difficulty_champ.setText(score.getDifficulty());
        //A voir si possibilité de recuperer les difficulté par le fichier string dans les conditions car String!=Int
        if (difficulty_champ.getText() == "EASY" && score.getNb_answers() == 6) {
            nbrep_champ.setText(R.string.perfect_label);
        } else if (difficulty_champ.getText() == "MEDIUM" && score.getNb_answers() == 7) {
            nbrep_champ.setText(R.string.perfect_label);
        } else if (difficulty_champ.getText() == "HARD" && score.getNb_answers() == 8) {
            nbrep_champ.setText(R.string.perfect_label);
        } else if (difficulty_champ.getText() == "NIGHTMARE" && score.getNb_answers() == 9) {
            nbrep_champ.setText(R.string.perfect_label);
        } else {
            nbrep_champ.setText(Integer.toString(score.getNb_answers()));
        }
        return cellView;
    }

}

