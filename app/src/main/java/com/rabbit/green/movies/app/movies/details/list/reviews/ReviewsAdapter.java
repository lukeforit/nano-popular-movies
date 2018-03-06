package com.rabbit.green.movies.app.movies.details.list.reviews;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.BaseAdapter;
import com.rabbit.green.movies.app.data.model.Review;

import javax.inject.Inject;

public class ReviewsAdapter extends BaseAdapter<ReviewViewHolder, Review> {

    @Inject
    ReviewsAdapter() {
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item_review, parent, false);
        return new ReviewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.bind(data.get(position));
    }
}
