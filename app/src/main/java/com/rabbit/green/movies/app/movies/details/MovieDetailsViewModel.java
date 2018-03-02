package com.rabbit.green.movies.app.movies.details;

import android.databinding.BaseObservable;

import com.rabbit.green.movies.app.BuildConfig;
import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.data.model.Movie;

import javax.inject.Inject;

public class MovieDetailsViewModel extends BaseObservable {

    @SuppressWarnings("WeakerAccess")
    @Inject
    ContextUtils contextUtils;

    private Movie movie;

    @Inject
    MovieDetailsViewModel() {
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getImageUrl() {
        return movie.getFullPosterPath(BuildConfig.BASE_POSTER_URL,
                contextUtils.getString(R.string.poster_size_w500));
    }

    public String getTitle() {
        return movie.getOriginalTitle();
    }

    public String getReleaseDate() {
        return movie.getReleaseDate();
    }

    public String getVotes() {
        return String.valueOf(movie.getVoteAverage());
    }

    public String getPlot() {
        return movie.getOverview();
    }
}
