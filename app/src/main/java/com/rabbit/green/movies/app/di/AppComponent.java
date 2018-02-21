package com.rabbit.green.movies.app.di;

import com.rabbit.green.movies.app.common.MoviesApp;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AppModule.class,
        ActivityContributorModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent {
    void inject(MoviesApp moviesApp);
}
