package com.rabbit.green.movies.app.di;

import com.rabbit.green.movies.app.data.repo.IMoviesRepository;
import com.rabbit.green.movies.app.data.repo.IMoviesRestService;
import com.rabbit.green.movies.app.data.repo.MoviesRetrofitRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder().build();
    }

    @Provides
    @Singleton
    public IMoviesRestService provideMoviesRestService(Retrofit retrofit) {
        return retrofit.create(IMoviesRestService.class);
    }

    @Provides
    @Singleton
    public IMoviesRepository provideMoviesRepository(IMoviesRestService restService) {
        return new MoviesRetrofitRepository(/*restService*/);
    }
}
