package com.example.memoris;

public class Score {
    private int id;

    private String difficulty;
    private int nb_answers;

    public Score(int id, String difficulty, int nb_answers) {
        this.id = id;
        this.difficulty = difficulty;
        this.nb_answers = nb_answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getNb_answers() {
        return nb_answers;
    }

    public void setNb_answers(int nb_answers) {
        this.nb_answers = nb_answers;
    }
}
