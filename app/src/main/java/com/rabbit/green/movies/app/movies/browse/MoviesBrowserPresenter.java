package com.rabbit.green.movies.app.movies.browse;

import android.os.Parcelable;

import com.rabbit.green.movies.app.data.cache.DummyCacheManager;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MoviesRequest;
import com.rabbit.green.movies.app.movies.BasePresenter;
import com.rabbit.green.movies.app.movies.UseCase;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class MoviesBrowserPresenter extends BasePresenter<MoviesBrowserViewModel> {

    @Inject
    DummyCacheManager cacheManager;

    private MoviesRequest ucParameters;

    private final UseCase<List<Movie>, MoviesRequest> browseMoviesUc =
            new UseCase<List<Movie>, MoviesRequest>() {
                @Override
                public void onSuccess(List<Movie> movies) {
                    viewModel.addMovies(movies);
                    viewModel.setLoadingData(false);
                    viewModel.setNoDataAvailable(false);
                }

                @Override
                public void onError() {
                    viewModel.setLoadingData(false);
                    viewModel.setNoDataAvailable(true);
                }

                @Override
                public List<Movie> call() throws Exception {
                    viewModel.setLoadingData(true);
                    switch (ucParameters.getDisplayPreference()) {
                        case MoviesRequest.PREF_BY_TOP_RATED:
                            return repository.getTopRatedMovies(parameters.getPage());
                        case MoviesRequest.PREF_FAVOURITES:
                            return localDataStore.getCachedMovies();
                        case MoviesRequest.PREF_BY_POPULARITY:
                        default:
                            return repository.getPopularMovies(parameters.getPage());
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

    void firstLoad() {
        if (cacheManager.isMoviesCacheEmpty()) {
            browseMoviesUc.execute(ucParameters);
        } else {
            viewModel.addMovies(cacheManager.getMoviesCache());
        }
    }

    void displayPreferenceChanged(int displayPreference) {
        viewModel.reset();
        ucParameters.setDisplayPreference(displayPreference);
        ucParameters.resetPage();
        browseMoviesUc.execute(ucParameters);
        cacheManager.invalidateMoviesCache();
    }

    Parcelable getParcelToSave() {
        return Parcels.wrap(ucParameters);
    }

    void restoreData(MoviesRequest data) {
        ucParameters = data;
    }

    void cacheData() {
        cacheManager.cacheMovies(viewModel.getData());
    }
}
