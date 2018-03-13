package com.rabbit.green.movies.app.data.cache;

import android.net.Uri;
import android.provider.BaseColumns;

import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.*;

public class MoviesContract {

    private static final String SCHEME = "content://";
    public static final String AUTHORITY = "com.rabbit.green.movies";
    public static final String PATH_MOVIE = "movie";

    public static final Uri BASE_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY);

    public static final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            _ID + " INTEGER PRIMARY KEY, " +
            COLUMN_TITLE + " TEXT NOT NULL, " +
            COLUMN_ORIGINAL_TITLE + " TEXT NOT NULL, " +
            COLUMN_VOTE_AVERAGE + " REAL NOT NULL, " +
            COLUMN_PLOT + " TEXT NOT NULL, " +
            COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
            COLUMN_RELEASE_DATE + " TEXT NOT NULL " +
            ");";

    public static class MovieEntry implements BaseColumns {

        public static final String TABLE_NAME = "movie";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_ORIGINAL_TITLE = "originalTitle";
        public static final String COLUMN_VOTE_AVERAGE = "voteAverage";
        public static final String COLUMN_POSTER_PATH = "posterPath";
        public static final String COLUMN_PLOT = "plot";
        public static final String COLUMN_RELEASE_DATE = "releaseDate";
        //TODO store image

        public static final Uri CONTENT_URI = BASE_CONTENT_URI
                .buildUpon()
                .appendPath(PATH_MOVIE)
                .build();

    }

}
