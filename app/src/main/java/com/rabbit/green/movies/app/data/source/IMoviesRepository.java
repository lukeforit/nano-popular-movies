package com.rabbit.green.movies.app.data.source;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.model.Review;
import com.rabbit.green.movies.app.data.model.Video;

import java.util.List;

public interface IMoviesRepository {

    List<Movie> getTopRatedMovies(int page);

    List<Movie> getPopularMovies(int page);
    
    List<Video> getVideos(int id);

    List<Review> getReviews(int id, int page);

}
