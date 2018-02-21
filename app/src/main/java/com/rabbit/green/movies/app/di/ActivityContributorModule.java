package com.rabbit.green.movies.app.di;

import com.rabbit.green.movies.app.movies.browse.MoviesBrowserActivity;
import com.rabbit.green.movies.app.movies.details.MovieDetailsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {
    @ContributesAndroidInjector
    abstract MoviesBrowserActivity contributeMoviesBrowserActivity();

    @ContributesAndroidInjector
    abstract MovieDetailsActivity contributeMovieDetailsActivity();
}
