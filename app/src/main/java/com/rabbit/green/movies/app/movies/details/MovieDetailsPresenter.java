package com.rabbit.green.movies.app.movies.details;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.Review;
import com.rabbit.green.movies.app.data.model.Video;
import com.rabbit.green.movies.app.data.model.MovieDetailsRequest;
import com.rabbit.green.movies.app.movies.BasePresenter;
import com.rabbit.green.movies.app.movies.UseCase;

import java.util.List;

import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class MovieDetailsPresenter extends BasePresenter<MovieDetailsViewModel> {

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

    @Inject
    MovieDetailsPresenter() {
    }

    void loadData(Movie movie) {
        viewModel.setMovie(movie);
        ucParameters = new MovieDetailsRequest(movie.getId());
        loadTrailersUc.execute(ucParameters);
        loadReviewsUc.execute(ucParameters);
    }
}
