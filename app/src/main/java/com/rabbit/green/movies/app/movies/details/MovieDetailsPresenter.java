package com.rabbit.green.movies.app.movies.details;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.movies.BasePresenter;

import javax.inject.Inject;

public class MovieDetailsPresenter extends BasePresenter<MovieDetailsViewModel> {
    @Inject
    MovieDetailsPresenter() {
    }

    @Override
    public void setup() {
    }

    public void loadData(Movie movie) {
        viewModel.setMovie(movie);
    }
}
