package com.rabbit.green.movies.app.movies.browse;

import android.os.Parcelable;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesRequest;
import com.rabbit.green.movies.app.movies.BasePresenter;
import com.rabbit.green.movies.app.movies.UseCase;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
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

    private final OnThresholdReachedListener onThresholdReachedListener =
            new OnThresholdReachedListener() {
                @Override
                public void onBottomReached() {
                    ucParameters.incrementPage();
                    loadData();
                }
            };

    //TODO save presenter state in activity
    @Inject
    MoviesBrowserPresenter() {
        ucParameters = new MoviesRequest();
    }

    void setup() {
        viewModel.setOnThresholdReachedListener(onThresholdReachedListener);
    }

    void loadData() {
        browseMoviesUc.execute(ucParameters);
    }

    void sortOrderChanged(boolean byPopularity) {
        ucParameters.setSortByPopularity(byPopularity);
        ucParameters.resetPage();
        browseMoviesUc.execute(ucParameters);
    }

    Parcelable getParcelToSave() {
        return Parcels.wrap(ucParameters);
    }

    void restoreData(MoviesRequest data) {
        ucParameters = data;
        //TODO fine more elegant way to keep current scroll position
        ucParameters.resetPage();
    }
}
