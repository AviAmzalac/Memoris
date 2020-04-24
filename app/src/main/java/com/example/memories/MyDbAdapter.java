package com.example.memories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MyDbAdapter {
    public static final int DB_version = 1;
    public static final String DB_name = "Memoris.db";

    private static final String leaderboard_table = "leaderboard";
    public static final String col_ID = "id";
    public static final String col_essai = "Essai";
    public static final String col_difficiculty = "Difficulte";
    public static final String col_nb_rep = "NBRanswers";

    private static final String create_leaderboard =
            String.format("create table %s(%s integer primary key autoincrement, %s integer autoincrement not null, %s text not null, %s integer not null);", leaderboard_table, col_ID, col_essai, col_difficiculty, col_nb_rep);

    private SQLiteDatabase myDataBase;
    private MyOpenHelper myOpenHelper;

    public MyDbAdapter(Context context) {
        myOpenHelper = new MyOpenHelper(context, DB_name, null, DB_version);
    }

    public void open() {
        myDataBase = myOpenHelper.getWritableDatabase();
    }

    public void close() {
        myDataBase.close();
    }

    public ArrayList<Score> getAllScore() {
        ArrayList<Score> scores = new ArrayList<Score>();
        Cursor c = myDataBase.query(leaderboard_table, new String[]{col_ID, col_essai, col_difficiculty, col_nb_rep},
                null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            scores.add(new Score(c.getInt(0), c.getInt(1), c.getString(2), c.getInt(3)));
            c.moveToNext();
        }
        c.close();
        return scores;
    }

    public long insert_score(String difficulty, int nb_answers) {
        ContentValues values = new ContentValues();
        values.put(col_difficiculty, difficulty);
        values.put(col_nb_rep, nb_answers);
        return myDataBase.insert(leaderboard_table, null, values);
    }

    private class MyOpenHelper extends SQLiteOpenHelper {
        public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version) {
            super(context, name, cursorFactory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(create_leaderboard);
            Log.i("test", "Test de création");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(String.format("drop table %s ;", create_leaderboard));
            onCreate(db);
        }
    }
}
