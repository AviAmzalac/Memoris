package com.example.memoris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.memories.R;

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
        switch (score.getDifficulty()){
            case "EASY":
                difficulty_champ.setText(R.string.button_easy);
                break;
            case "MEDIUM":
                difficulty_champ.setText(R.string.button_medium);
                break;
            case "HARD":
                difficulty_champ.setText(R.string.button_hard);
                break;
            case "NIGHTMARE":
                difficulty_champ.setText(R.string.button_competitive);
                break;
            default:
                difficulty_champ.setText("");
                break;
        }

        //A voir si possibilité de recuperer les difficulté par le fichier string dans les conditions car String!=Int
        if (score.getDifficulty().equals("EASY") && score.getNb_answers() == 5) {
            nbrep_champ.setText(R.string.perfect_label);
        } else if (score.getDifficulty().equals("MEDIUM") && score.getNb_answers() == 6) {
            nbrep_champ.setText(R.string.perfect_label);
        } else if (score.getDifficulty().equals("HARD") && score.getNb_answers() == 7) {
            nbrep_champ.setText(R.string.perfect_label);
        } else if (score.getDifficulty().equals("NIGHTMARE") && score.getNb_answers() == 7) {
            nbrep_champ.setText(R.string.perfect_label);
        } else {
            nbrep_champ.setText(Integer.toString(score.getNb_answers()));
        }
        return cellView;
    }

}

