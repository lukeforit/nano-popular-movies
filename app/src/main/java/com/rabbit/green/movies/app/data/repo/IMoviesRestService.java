package com.rabbit.green.movies.app.data.repo;

import com.rabbit.green.movies.app.data.model.MoviesResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMoviesRestService {

    @GET("3/movie/top_rated")
    Single<Response<MoviesResponse>> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("3/movie/popular")
    Single<Response<MoviesResponse>> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page);
}
