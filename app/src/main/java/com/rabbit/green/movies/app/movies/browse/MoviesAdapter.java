package com.rabbit.green.movies.app.movies.browse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.rabbit.green.movies.app.data.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Movie> mData;

    public MoviesAdapter(Context context, int resource) {
        mContext = context;
        mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        Picasso.with(mContext).load(IMoviesRepository.posterPath(mData.get(position).getmPoster())).into(imageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
