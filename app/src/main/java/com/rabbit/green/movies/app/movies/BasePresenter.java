package com.rabbit.green.movies.app.movies;

import com.rabbit.green.movies.app.data.repo.IMoviesRepository;

import javax.inject.Inject;

public abstract class BasePresenter<VM> {
    @Inject
    protected VM viewModel;
    @Inject
    protected IMoviesRepository repository;

    VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }

    public abstract void setup();
}
