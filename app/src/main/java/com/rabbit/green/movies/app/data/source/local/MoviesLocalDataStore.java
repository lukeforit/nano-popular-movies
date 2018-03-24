package com.rabbit.green.movies.app.data.source.local;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

import com.rabbit.green.movies.app.data.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesLocalDataStore {

    private final ContentResolver resolver;

    public MoviesLocalDataStore(ContentResolver resolver) {
        this.resolver = resolver;
    }

    public List<Movie> getCachedMovies() {
        Cursor cursor = resolver.query(MoviesContract.MovieEntry.CONTENT_URI,
                new String[]{BaseColumns._ID,
                        MoviesContract.MovieEntry.COLUMN_ORIGINAL_TITLE,
                        MoviesContract.MovieEntry.COLUMN_TITLE,
                        MoviesContract.MovieEntry.COLUMN_PLOT,
                        MoviesContract.MovieEntry.COLUMN_POSTER_PATH,
                        MoviesContract.MovieEntry.COLUMN_BACKDROP_PATH,
                        MoviesContract.MovieEntry.COLUMN_RELEASE_DATE,
                        MoviesContract.MovieEntry.COLUMN_VOTE_AVERAGE},
                null, null, null);
        List<Movie> result = new ArrayList<>();
        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    result.add(mapCursorToMovie(cursor));
                }
            } finally {
                cursor.close();
            }
        }
        return result;
    }

    public Movie getMovie(int id) {
        Cursor cursor = resolver.query(ContentUris.withAppendedId(MoviesContract.MovieEntry.CONTENT_URI, id),
                new String[]{BaseColumns._ID,
                        MoviesContract.MovieEntry.COLUMN_ORIGINAL_TITLE,
                        MoviesContract.MovieEntry.COLUMN_TITLE,
                        MoviesContract.MovieEntry.COLUMN_PLOT,
                        MoviesContract.MovieEntry.COLUMN_POSTER_PATH,
                        MoviesContract.MovieEntry.COLUMN_BACKDROP_PATH,
                        MoviesContract.MovieEntry.COLUMN_RELEASE_DATE,
                        MoviesContract.MovieEntry.COLUMN_VOTE_AVERAGE},
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            try {
                return mapCursorToMovie(cursor);
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public void insertMovie(Movie movie) {
        resolver.insert(MoviesContract.MovieEntry.CONTENT_URI, mapMovieToContentValues(movie));
    }

    @SuppressWarnings("UnusedReturnValue")
    public int deleteMovie(Movie movie) {
        return resolver.delete(
                ContentUris.withAppendedId(MoviesContract.MovieEntry.CONTENT_URI, movie.getId()),
                null,
                null);
    }

    private Movie mapCursorToMovie(@NonNull Cursor cursor) {
        Movie movie = new Movie();
        movie.setId(cursor.getInt(cursor.getColumnIndex(BaseColumns._ID)));
        movie.setOriginalTitle(cursor.getString(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_ORIGINAL_TITLE)));
        movie.setTitle(cursor.getString(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_TITLE)));
        movie.setOverview(cursor.getString(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_PLOT)));
        movie.setPosterPath(cursor.getString(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_POSTER_PATH)));
        movie.setBackdropPath(cursor.getString(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_BACKDROP_PATH)));
        movie.setReleaseDate(cursor.getString(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_RELEASE_DATE)));
        movie.setVoteAverage(cursor.getInt(cursor.getColumnIndex(MoviesContract.MovieEntry.COLUMN_VOTE_AVERAGE)));
        return movie;
    }

    private ContentValues mapMovieToContentValues(Movie movie) {
        ContentValues values = new ContentValues();
        values.put(BaseColumns._ID, movie.getId());
        values.put(MoviesContract.MovieEntry.COLUMN_ORIGINAL_TITLE, movie.getOriginalTitle());
        values.put(MoviesContract.MovieEntry.COLUMN_TITLE, movie.getTitle());
        values.put(MoviesContract.MovieEntry.COLUMN_PLOT, movie.getOverview());
        values.put(MoviesContract.MovieEntry.COLUMN_POSTER_PATH, movie.getPosterPath());
        values.put(MoviesContract.MovieEntry.COLUMN_BACKDROP_PATH, movie.getBackdropPath());
        values.put(MoviesContract.MovieEntry.COLUMN_RELEASE_DATE, movie.getReleaseDate());
        values.put(MoviesContract.MovieEntry.COLUMN_VOTE_AVERAGE, movie.getVoteAverage());
        return values;
    }
}
