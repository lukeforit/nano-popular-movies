package com.rabbit.green.movies.app.movies.details;

import android.databinding.BaseObservable;

import com.rabbit.green.movies.app.BuildConfig;
import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.Review;
import com.rabbit.green.movies.app.data.model.Video;
import com.rabbit.green.movies.app.movies.details.list.reviews.ReviewsAdapter;
import com.rabbit.green.movies.app.movies.details.list.videos.VideosAdapter;

import java.util.List;

import javax.inject.Inject;

public class MovieDetailsViewModel extends BaseObservable {

    @SuppressWarnings("WeakerAccess")
    @Inject
    ContextUtils contextUtils;

    @Inject
    VideosAdapter videosAdapter;

    @Inject
    ReviewsAdapter reviewsAdapter;

    private Movie movie;

    @Inject
    MovieDetailsViewModel() {
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getImageUrl() {
        return movie.getFullPosterPath(BuildConfig.BASE_POSTER_URL,
                contextUtils.getString(R.string.poster_size));
    }

    public String getTitle() {
        return movie.getOriginalTitle();
    }

    public String getReleaseDate() {
        return movie.getReleaseDate();
    }

    public String getVotes() {
        return String.valueOf(movie.getVoteAverage());
    }

    public String getPlot() {
        return movie.getOverview();
    }

    public VideosAdapter getVideosAdapter() {
        return videosAdapter;
    }

    public ReviewsAdapter getReviewsAdapter() {
        return reviewsAdapter;
    }

    public void addVideos(List<Video> data) {
        videosAdapter.addData(data);
    }

    public void addReviews(List<Review> data) {
        reviewsAdapter.addData(data);
    }
}
