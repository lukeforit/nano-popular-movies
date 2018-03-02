package com.rabbit.green.movies.app.data.repo;

import android.support.annotation.Nullable;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MoviesRetrofitRepository implements IMoviesRepository {

    private final String apiKey;
    private final IMoviesRestService restService;

    public MoviesRetrofitRepository(IMoviesRestService restService, String apiKey) {
        this.restService = restService;
        this.apiKey = apiKey;
    }

    @Override
    public List<Movie> getTopRatedMovies(int page) {
        return unwrapRetrofitCallMoviesResponse(restService.movieTopRated(apiKey, page));
    }

    @Override
    public List<Movie> getPopularMovies(int page) {
        return unwrapRetrofitCallMoviesResponse(restService.moviePopular(apiKey, page));
    }

    @Nullable
    private List<Movie> unwrapRetrofitCallMoviesResponse(Call<MoviesResponse> call) {
        try {
            Response<MoviesResponse> response = call.execute();
            MoviesResponse body = response.body();
            return response.isSuccessful() && body != null ? body.getResults() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
