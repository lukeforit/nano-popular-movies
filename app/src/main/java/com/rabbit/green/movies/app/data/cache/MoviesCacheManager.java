package com.rabbit.green.movies.app.data.cache;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.rabbit.green.movies.app.data.model.Movie;

import java.util.ArrayList;
import java.util.List;

import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.COLUMN_ORIGINAL_TITLE;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.COLUMN_PLOT;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.COLUMN_POSTER_PATH;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.COLUMN_RELEASE_DATE;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.COLUMN_TITLE;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.COLUMN_VOTE_AVERAGE;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry.CONTENT_URI;
import static com.rabbit.green.movies.app.data.cache.MoviesContract.MovieEntry._ID;

public class MoviesCacheManager {

    private ContentResolver resolver;

    public MoviesCacheManager(ContentResolver resolver) {
        this.resolver = resolver;
    }

    public List<Movie> getCachedMovies() {
        Cursor cursor = resolver.query(CONTENT_URI,
                new String[]{_ID,
                        COLUMN_ORIGINAL_TITLE,
                        COLUMN_TITLE,
                        COLUMN_PLOT,
                        COLUMN_POSTER_PATH,
                        COLUMN_RELEASE_DATE,
                        COLUMN_VOTE_AVERAGE},
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
        Cursor cursor = resolver.query(ContentUris.withAppendedId(CONTENT_URI, id),
                new String[]{_ID,
                        COLUMN_ORIGINAL_TITLE,
                        COLUMN_TITLE,
                        COLUMN_PLOT,
                        COLUMN_POSTER_PATH,
                        COLUMN_RELEASE_DATE,
                        COLUMN_VOTE_AVERAGE},
                null, null, null);
        if (cursor != null) {
            try {
                return mapCursorToMovie(cursor);
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public void insertMovie(Movie movie) {
        resolver.insert(CONTENT_URI, mapMovieToContentValues(movie));
    }

    public int deleteMovie(Movie movie) {
        return resolver.delete(
                ContentUris.withAppendedId(CONTENT_URI, movie.getId()),
                null,
                null);
    }

    private Movie mapCursorToMovie(@NonNull Cursor cursor) {
        Movie movie = new Movie();
        movie.setId(cursor.getInt(cursor.getColumnIndex(_ID)));
        movie.setOriginalTitle(cursor.getString(cursor.getColumnIndex(COLUMN_ORIGINAL_TITLE)));
        movie.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
        movie.setOverview(cursor.getString(cursor.getColumnIndex(COLUMN_PLOT)));
        movie.setPosterPath(cursor.getString(cursor.getColumnIndex(COLUMN_POSTER_PATH)));
        movie.setReleaseDate(cursor.getString(cursor.getColumnIndex(COLUMN_RELEASE_DATE)));
        movie.setVoteAverage(cursor.getInt(cursor.getColumnIndex(COLUMN_VOTE_AVERAGE)));
        return movie;
    }

    private ContentValues mapMovieToContentValues(Movie movie) {
        ContentValues values = new ContentValues();
        values.put(_ID, movie.getId());
        values.put(COLUMN_ORIGINAL_TITLE, movie.getOriginalTitle());
        values.put(COLUMN_TITLE, movie.getTitle());
        values.put(COLUMN_PLOT, movie.getOverview());
        values.put(COLUMN_POSTER_PATH, movie.getPosterPath());
        values.put(COLUMN_RELEASE_DATE, movie.getReleaseDate());
        values.put(COLUMN_VOTE_AVERAGE, movie.getVoteAverage());
        return values;
    }
}
