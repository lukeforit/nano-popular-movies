package com.rabbit.green.movies.app.data.cache;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.Review;
import com.rabbit.green.movies.app.data.model.Video;

import java.util.ArrayList;
import java.util.List;

public class DummyCacheManager {

    private final List<Movie> moviesCache = new ArrayList<>();
    private final List<Video> videosCache = new ArrayList<>();
    private final List<Review> reviewsCache = new ArrayList<>();

    public void cacheMovies(List<Movie> data) {
        moviesCache.clear();
        moviesCache.addAll(data);
    }

    public void cacheVideos(List<Video> data) {
        videosCache.clear();
        videosCache.addAll(data);
    }

    public void cacheReviews(List<Review> data) {
        reviewsCache.clear();
        reviewsCache.addAll(data);
    }

    public List<Movie> getMoviesCache() {
        return new ArrayList<>(moviesCache);
    }

    public List<Video> getVideosCache() {
        return new ArrayList<>(videosCache);
    }

    public List<Review> getReviewsCache() {
        return new ArrayList<>(reviewsCache);
    }

    public void invalidateMoviesCache() {
        moviesCache.clear();
    }
    public void invalidateVideosCache() {
        videosCache.clear();
    }
    public void invalidateReviewsCache() {
        reviewsCache.clear();
    }

    public boolean isMoviesCacheEmpty() {
        return moviesCache.isEmpty();
    }

    public boolean isVideosCacheEmpty() {
        return videosCache.isEmpty();
    }

    public boolean isReviewsCacheEmpty() {
        return reviewsCache.isEmpty();
    }
}
