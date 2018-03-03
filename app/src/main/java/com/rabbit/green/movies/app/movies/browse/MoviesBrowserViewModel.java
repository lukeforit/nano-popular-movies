package com.rabbit.green.movies.app.movies.browse;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rabbit.green.movies.app.BR;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.movies.browse.grid.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MoviesBrowserViewModel extends BaseObservable {

    @SuppressWarnings("WeakerAccess")
    @Inject
    MoviesAdapter adapter;

    @Inject
    ContextUtils contextUtils;

    @SuppressWarnings("WeakerAccess")
    @Inject
    GridLayoutManager gridLayoutManager;

    private boolean loadingData;

    private OnThresholdReachedListener onThresholdReachedListener;

    private final RecyclerView.OnScrollListener onScrollListener =
            new RecyclerView.OnScrollListener() {
                @SuppressWarnings("EmptyMethod")
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
                        if (total <= last + columns && !loadingData) {
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

    void addMovies(List<Movie> movies) {
        adapter.addData(movies);
    }

    public GridLayoutManager getLayoutManager() {
        return gridLayoutManager;
    }

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return onScrollListener;
    }

    @BindingAdapter("onScrollListener")
    public static void setOnScrollListener(RecyclerView rv, RecyclerView.OnScrollListener listener) {
        rv.addOnScrollListener(listener);
    }

    void setOnThresholdReachedListener(OnThresholdReachedListener onThresholdReachedListener) {
        this.onThresholdReachedListener = onThresholdReachedListener;
    }

    void reset() {
        adapter.clear();
    }

    void setLoadingData(boolean loadingData) {
        this.loadingData = loadingData;
        notifyPropertyChanged(BR.progressBarVisibility);
    }

    @Bindable
    public int getProgressBarVisibility() {
        return loadingData ? View.VISIBLE : View.GONE;
    }
}
