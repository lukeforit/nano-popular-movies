package com.rabbit.green.movies.app.movies.browse;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesRequest;
import com.rabbit.green.movies.app.movies.BasePresenter;
import com.rabbit.green.movies.app.movies.UseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

public class MoviesBrowserPresenter extends BasePresenter<MoviesBrowserViewModel> {

    private MoviesRequest ucParameters;

    private final UseCase<List<Movie>, MoviesRequest> browseMoviesUc =
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
                    if (ucParameters.isSortByPopularity()) {
                        return repository.getPopularMovies(parameters.getPage());
                    } else {
                        return repository.getTopRatedMovies(parameters.getPage());
                    }
                }
            };

    //TODO save presenter state in activity
    @Inject
    MoviesBrowserPresenter() {
        ucParameters = new MoviesRequest();
    }

    @Override
    public void setup() {
        browseMoviesUc.execute(ucParameters);
    }

    public boolean sortOrderChanged() {
        ucParameters.reverseSort();
        ucParameters.resetPage();
        browseMoviesUc.execute(ucParameters);
        return ucParameters.isSortByPopularity();
    }
}
