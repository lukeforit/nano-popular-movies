package com.rabbit.green.movies.app.di;

import android.content.Context;

import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.common.MoviesApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApiModule.class)
public class AppModule {

    @Provides
    @Singleton
    public Context provideAppContext(MoviesApp app) {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    public ContextUtils provideContextUtils(Context context) {
        return new ContextUtils(context);
    }
}
