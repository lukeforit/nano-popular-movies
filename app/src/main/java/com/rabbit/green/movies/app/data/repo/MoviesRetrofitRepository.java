package com.rabbit.green.movies.app.data.repo;

import android.support.annotation.Nullable;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MoviesRetrofitRepository implements IMoviesRepository {
    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String DISCOVER = "discover/movie";
    private static final String MOVIE = "movie";
    private static final String SORT_BY_PARAM = "sort_by";
    private static final String SORT_BY_POPULARITY = "popularity.desc";
    private static final String SORT_BY_RELEASE_DATE = "release_date.desc";
    private static final String SORT_BY_VOTE_AVERAGE = "vote_average.desc";
    private static final String API_KEY_PARAM = "api_key";

    private static final String JSON_MOVIES_ARRAY = "results";
    private static final String JSON_POSTER_PATH = "poster_path";
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_VOTE_AVERAGE = "vote_average";
    private static final String JSON_OVERVIEW = "overview";
    private static final String JSON_RELEASE_DATE = "release_date";

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
