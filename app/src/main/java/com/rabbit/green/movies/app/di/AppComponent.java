package com.rabbit.green.movies.app.di;

import com.rabbit.green.movies.app.common.MoviesApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityContributorModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent {
    void inject(MoviesApp moviesApp);
}
