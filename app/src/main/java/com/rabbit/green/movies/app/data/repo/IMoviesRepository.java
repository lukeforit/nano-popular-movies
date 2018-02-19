package com.rabbit.green.movies.app.data.repo;

import com.rabbit.green.movies.app.data.model.Movie;

import java.util.List;

public interface IMoviesRepository {

    List<Movie> getTopRatedMovies(int page);

    List<Movie> getPopularMovies(int page);

}
