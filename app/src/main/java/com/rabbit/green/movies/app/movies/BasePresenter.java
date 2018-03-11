package com.rabbit.green.movies.app.movies;

import com.rabbit.green.movies.app.data.cache.MoviesCacheManager;
import com.rabbit.green.movies.app.data.repo.IMoviesRepository;

import javax.inject.Inject;

public abstract class BasePresenter<VM> {
    @Inject
    protected VM viewModel;
    @Inject
    protected IMoviesRepository repository;
    @Inject
    protected MoviesCacheManager cacheManager;

    VM getViewModel() {
        return viewModel;
    }
}
