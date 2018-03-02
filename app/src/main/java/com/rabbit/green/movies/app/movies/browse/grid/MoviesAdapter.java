package com.rabbit.green.movies.app.movies.browse.grid;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rabbit.green.movies.app.BuildConfig;
import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.data.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class MoviesAdapter extends RecyclerView.Adapter<PosterViewHolder>
        implements OnViewHolderClickListener {

    private List<Movie> data;

    @Inject
    ContextUtils contextUtils;

    @Inject
    MoviesAdapter() {
    }

    @Override
    public PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.grid_view_poster, parent, false);
        return new PosterViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(PosterViewHolder holder, int position) {
        holder.bind(data.get(position).getFullPosterPath(BuildConfig.BASE_POSTER_URL,
                contextUtils.getString(R.string.poster_size_w185)));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void addData(List<Movie> data) {
        if (this.data == null) {
            this.data = data;
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onViewHolderClick(int position) {
        contextUtils.navigateToMovieDetails(data.get(position));
    }
}
