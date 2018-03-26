package com.rabbit.green.movies.app.movies.details;

import com.rabbit.green.movies.app.data.cache.DummyCacheManager;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.MovieDetailsRequest;
import com.rabbit.green.movies.app.data.model.Review;
import com.rabbit.green.movies.app.data.model.Video;
import com.rabbit.green.movies.app.movies.BasePresenter;
import com.rabbit.green.movies.app.movies.UseCase;

import java.util.List;

import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class MovieDetailsPresenter extends BasePresenter<MovieDetailsViewModel> {

    @Inject
    DummyCacheManager cacheManager;

    private MovieDetailsRequest ucParameters;

    private final UseCase<List<Video>, MovieDetailsRequest> loadTrailersUc =
            new UseCase<List<Video>, MovieDetailsRequest>() {
                @Override
                public void onSuccess(List<Video> videos) {
                    viewModel.addVideos(videos);
                }

                @Override
                public void onError() {

                }

                @Override
                public List<Video> call() throws Exception {
                    return repository.getVideos(parameters.getId());
                }
            };

    private final UseCase<List<Review>, MovieDetailsRequest> loadReviewsUc =
            new UseCase<List<Review>, MovieDetailsRequest>() {
                @Override
                public void onSuccess(List<Review> reviews) {
                    viewModel.addReviews(reviews);
                }

                @Override
                public void onError() {

                }

                @Override
                public List<Review> call() throws Exception {
                    return repository.getReviews(parameters.getId(), parameters.getPage());
                }
            };

    private final UseCase<Movie, MovieDetailsRequest> retrieveLocalStoreUc =
            new UseCase<Movie, MovieDetailsRequest>() {
                @Override
                public void onSuccess(Movie movie) {
                    movie.setFavourite(true);
                    viewModel.setMovie(movie);
                    loadReviewsAndTrailers();
                }

                @Override
                public void onError() {
                    loadReviewsAndTrailers();
                }

                @Override
                public Movie call() throws Exception {
                    return localDataStore.getMovie(parameters.getId());
                }
            };

    private final UseCase<Void, Movie> reverseFavouriteUc =
            new UseCase<Void, Movie>() {
                @Override
                public void onSuccess(Void aVoid) {
                }

                @Override
                public void onError() {

                }

                @Override
                public Void call() throws Exception {
                    if (parameters.isFavourite()) {
                        localDataStore.insertMovie(parameters);
                    } else {
                        localDataStore.deleteMovie(parameters);
                    }
                    return null;
                }
            };

    @Inject
    MovieDetailsPresenter() {
    }

    public void setup() {
        viewModel.setPresenter(this);
    }

    void loadData(Movie movie) {
        viewModel.setMovie(movie);
        ucParameters = new MovieDetailsRequest(movie.getId());
        if (!cacheManager.isVideosCacheEmpty() && !cacheManager.isReviewsCacheEmpty()) {
            viewModel.addVideos(cacheManager.getVideosCache());
            viewModel.addReviews(cacheManager.getReviewsCache());
        } else {
            retrieveLocalStoreUc.execute(ucParameters);
        }
    }

    private void loadReviewsAndTrailers() {
        loadTrailersUc.execute(ucParameters);
        loadReviewsUc.execute(ucParameters);
    }

    public void reverseFavourite(Movie movie) {
        reverseFavouriteUc.execute(movie);
    }

    public void cacheData() {
        cacheManager.cacheVideos(viewModel.getVideosAdapter().getData());
        cacheManager.cacheReviews(viewModel.getReviewsAdapter().getData());
    }

    public void invalidateCache() {
        cacheManager.invalidateVideosCache();
        cacheManager.invalidateReviewsCache();
    }
}
