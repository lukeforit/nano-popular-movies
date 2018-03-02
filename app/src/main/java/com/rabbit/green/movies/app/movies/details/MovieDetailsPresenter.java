package com.rabbit.green.movies.app.movies.details;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.movies.BasePresenter;

import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class MovieDetailsPresenter extends BasePresenter<MovieDetailsViewModel> {
    @Inject
    MovieDetailsPresenter() {
    }

    void loadData(Movie movie) {
        viewModel.setMovie(movie);
    }
}
