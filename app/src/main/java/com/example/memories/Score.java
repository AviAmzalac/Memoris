package com.example.memories;

public class Score {
    private int id;
    private int essai;
    private String difficulty;
    private int nb_answers;

    public Score(int id, int essai, String difficulty, int nb_answers) {
        this.id = id;
        this.essai = essai;
        this.difficulty = difficulty;
        this.nb_answers = nb_answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEssai() {
        return essai;
    }

    public void setEssai(int essai) {
        this.essai = essai;
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
