package com.rabbit.green.movies.app.data.source.net;

import android.support.annotation.Nullable;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesResponse;
import com.rabbit.green.movies.app.data.model.Review;
import com.rabbit.green.movies.app.data.model.ReviewsResponse;
import com.rabbit.green.movies.app.data.model.Video;
import com.rabbit.green.movies.app.data.model.VideosResponse;
import com.rabbit.green.movies.app.data.source.IMoviesRepository;

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

    @Override
    public List<Video> getVideos(int id) {
        try {
            Response<VideosResponse> response = restService.movieVideos(id, apiKey).execute();
            VideosResponse body = response.body();
            return response.isSuccessful() && body != null ? body.getResults() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Review> getReviews(int id, int page) {
        try {
            //TODO make use of total pages
            Response<ReviewsResponse> response = restService.movieReviews(id, apiKey, page).execute();
            ReviewsResponse body = response.body();
            return response.isSuccessful() && body != null ? body.getResults() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    private List<Movie> unwrapRetrofitCallMoviesResponse(Call<MoviesResponse> call) {
        try {
            //TODO make use of total pages
            Response<MoviesResponse> response = call.execute();
            MoviesResponse body = response.body();
            return response.isSuccessful() && body != null ? body.getResults() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
