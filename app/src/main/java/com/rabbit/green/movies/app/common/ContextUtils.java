package com.rabbit.green.movies.app.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.movies.details.MovieDetailsActivity;

import org.parceler.Parcels;

public class ContextUtils {
    private final Context context;

    private static final String YOUTUBE_APP_URI = "vnd.youtube:";
    private static final String YOUTUBE_BROWSER_URI = "http://www.youtube.com/watch?v=";

    public ContextUtils(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public String getString(@StringRes int stringId) {
        return context.getString(stringId);
    }

    public int getInteger(@SuppressWarnings("SameParameterValue") @IntegerRes int intId) {
        return context.getResources().getInteger(intId);
    }

    public void navigateToMovieDetails(Movie movie) {
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.BUNDLE_KEY_MOVIE, Parcels.wrap(movie));
        context.startActivity(intent);
    }

    public void runYouTubeApp(String videoId) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_APP_URI + videoId));
        context.startActivity(intent);
    }

    public void runYouTubeInBrowser(String videoId) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_BROWSER_URI + videoId));
        context.startActivity(intent);
    }
}
