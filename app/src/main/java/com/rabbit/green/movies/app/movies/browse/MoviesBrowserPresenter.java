package com.rabbit.green.movies.app.movies.browse;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesRequest;
import com.rabbit.green.movies.app.movies.BasePresenter;
import com.rabbit.green.movies.app.movies.UseCase;

import java.util.List;

import javax.inject.Inject;

public class MoviesBrowserPresenter extends BasePresenter<MoviesBrowserViewModel> {

    private UseCase<List<Movie>, MoviesRequest> browseMoviesUc =
            new UseCase<List<Movie>, MoviesRequest>() {
                @Override
                public void onSuccess(List<Movie> movies) {
                    viewModel.addMovies(movies);
                }

                @Override
                public void onError() {

                }

                @Override
                public List<Movie> call() throws Exception {
                    return repository.getPopularMovies(parameters.getPage());
                }
            };

    @Inject
    MoviesBrowserPresenter() {
    }

    @Override
    public void setup() {
        browseMoviesUc.execute(new MoviesRequest(1));
    }
}
