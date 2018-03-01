package com.rabbit.green.movies.app.common;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.movies.details.MovieDetailsActivity;

import org.parceler.Parcels;

public class ContextUtils {
    private final Context context;

    public ContextUtils(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public String getString(@StringRes int stringId) {
        return context.getString(stringId);
    }

    public int getInteger(@IntegerRes int intId) {
        return context.getResources().getInteger(intId);
    }

    public void navigateToMovieDetails(Movie movie) {
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.BUNDLE_KEY_MOVIE, Parcels.wrap(movie));
        context.startActivity(intent);
    }
}
