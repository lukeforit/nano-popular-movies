package com.rabbit.green.movies.app.data.cache;

import android.net.Uri;
import android.provider.BaseColumns;

import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.*;

public class MoviesContract {

    private static final String SCHEME = "content://";
    public static final String AUTHORITY = "com.rabbit.green.movies";
    static final String PATH_MOVIE = "movie";

    private static final Uri BASE_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY);

    static final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            _ID + " INTEGER PRIMARY KEY, " +
            COLUMN_TITLE + " TEXT NOT NULL, " +
            COLUMN_ORIGINAL_TITLE + " TEXT NOT NULL, " +
            COLUMN_VOTE_AVERAGE + " REAL NOT NULL, " +
            COLUMN_PLOT + " TEXT NOT NULL, " +
            COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
            COLUMN_BACKDROP_PATH + " TEXT NOT NULL, " +
            COLUMN_RELEASE_DATE + " TEXT NOT NULL " +
            ");";

    static class MovieEntry implements BaseColumns {

        static final String TABLE_NAME = "movie";
        static final String COLUMN_TITLE = "title";
        static final String COLUMN_ORIGINAL_TITLE = "originalTitle";
        static final String COLUMN_VOTE_AVERAGE = "voteAverage";
        static final String COLUMN_POSTER_PATH = "posterPath";
        static final String COLUMN_BACKDROP_PATH = "backdropPath";
        static final String COLUMN_PLOT = "plot";
        static final String COLUMN_RELEASE_DATE = "releaseDate";
        //TODO store image

        static final Uri CONTENT_URI = BASE_CONTENT_URI
                .buildUpon()
                .appendPath(PATH_MOVIE)
                .build();

    }

}
