package com.rabbit.green.movies.app.movies.browse;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    GridLayoutManager gridLayoutManager;

    private OnThresholdReachedListener onThresholdReachedListener;

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy > 0) {
                int last = gridLayoutManager.findLastCompletelyVisibleItemPosition();
                int total = gridLayoutManager.getItemCount();
                int columns = gridLayoutManager.getSpanCount();
                if (total <= last + columns) {
                    onThresholdReachedListener.onBottomReached();
                }
            }
        }
    };

    @Inject
    MoviesBrowserViewModel() {
    }

    public MoviesAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(MoviesAdapter adapter) {
        this.adapter = adapter;
    }

    void addMovies(List<Movie> movies) {
        adapter.addData(movies);
    }

    public GridLayoutManager getLayoutManager() {
        return gridLayoutManager;
    }

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return onScrollListener;
    }

    @BindingAdapter("bind:onScrollListener")
    public static void setOnScrollListener(RecyclerView rv, RecyclerView.OnScrollListener listener) {
        rv.addOnScrollListener(listener);
    }

    public void setOnThresholdReachedListener(OnThresholdReachedListener onThresholdReachedListener) {
        this.onThresholdReachedListener = onThresholdReachedListener;
    }
}
