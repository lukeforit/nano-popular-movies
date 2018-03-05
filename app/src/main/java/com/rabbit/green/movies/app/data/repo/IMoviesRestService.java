package com.rabbit.green.movies.app.data.repo;

import com.rabbit.green.movies.app.data.model.MoviesResponse;
import com.rabbit.green.movies.app.data.model.ReviewsResponse;
import com.rabbit.green.movies.app.data.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IMoviesRestService {

    @GET("3/movie/top_rated")
    Call<MoviesResponse> movieTopRated(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("3/movie/popular")
    Call<MoviesResponse> moviePopular(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("3/movie/{id}/videos")
    Call<List<Video>> movieVideos(
            @Query("api_key") String apiKey,
            @Path("id") int id);

    @GET("3/movie/{id}/reviews")
    Call<ReviewsResponse> movieReviews(
            @Query("api_key") String apiKey,
            @Path("id") int id,
            @Query("page") int page);
}
