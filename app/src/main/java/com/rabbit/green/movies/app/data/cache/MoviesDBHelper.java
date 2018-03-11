package com.rabbit.green.movies.app.data.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.TABLE_NAME;

public class MoviesDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "movies_db";
    private static final int DB_VERSION = 1;

    public MoviesDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MoviesContract.SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
