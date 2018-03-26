package com.rabbit.green.movies.app.movies;

import com.rabbit.green.movies.app.data.source.local.MoviesLocalDataStore;
import com.rabbit.green.movies.app.data.source.IMoviesRepository;

import javax.inject.Inject;

public abstract class BasePresenter<VM> {
    @Inject
    protected VM viewModel;
    @Inject
    protected IMoviesRepository repository;
    @Inject
    protected MoviesLocalDataStore localDataStore;

    VM getViewModel() {
        return viewModel;
    }
}
