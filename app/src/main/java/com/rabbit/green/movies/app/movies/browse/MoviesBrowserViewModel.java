package com.rabbit.green.movies.app.movies.browse;

import android.support.v7.widget.GridLayoutManager;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.movies.browse.grid.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MoviesBrowserViewModel {

    @Inject
    MoviesAdapter adapter;

    @Inject
    ContextUtils contextUtils;

    @Inject
    MoviesBrowserViewModel() {
    }

    public MoviesAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(MoviesAdapter adapter) {
        this.adapter = adapter;
    }

    public void addMovies(List<Movie> movies) {
        adapter.setData(movies);
    }

    public GridLayoutManager getLayoutManager() {
        return new GridLayoutManager(contextUtils.getContext(),
                contextUtils.getInteger(R.integer.grid_columns_number));
    }
}
