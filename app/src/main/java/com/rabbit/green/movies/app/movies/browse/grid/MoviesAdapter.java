package com.rabbit.green.movies.app.movies.browse.grid;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rabbit.green.movies.app.BuildConfig;
import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.BaseAdapter;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.data.model.Movie;

import javax.inject.Inject;

public class MoviesAdapter extends BaseAdapter<PosterViewHolder, Movie>
        implements OnViewHolderClickListener {

    @SuppressWarnings("WeakerAccess")
    @Inject
    ContextUtils contextUtils;

    @Inject
    MoviesAdapter() {
    }

    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.grid_view_poster, parent, false);
        return new PosterViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        holder.bind(data.get(position).getFullPosterPath(BuildConfig.BASE_POSTER_URL,
                contextUtils.getString(R.string.thumbnail_size)));
    }

    @Override
    public void onViewHolderClick(int position) {
        contextUtils.navigateToMovieDetails(data.get(position));
    }
}
