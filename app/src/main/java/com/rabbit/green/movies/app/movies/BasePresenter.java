package com.rabbit.green.movies.app.movies;

import com.rabbit.green.movies.app.data.cache.MoviesLocalDataStore;
import com.rabbit.green.movies.app.data.repo.IMoviesRepository;

import javax.inject.Inject;

public abstract class BasePresenter<VM> {
    @Inject
    protected VM viewModel;
    @Inject
    protected IMoviesRepository repository;
    @Inject
    protected MoviesLocalDataStore cacheManager;

    VM getViewModel() {
        return viewModel;
    }
}
