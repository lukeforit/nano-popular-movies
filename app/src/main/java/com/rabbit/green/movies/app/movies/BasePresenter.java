package com.rabbit.green.movies.app.movies;

import javax.inject.Inject;

public class BasePresenter<VM> {
    @Inject
    protected VM viewModel;

    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }
}
