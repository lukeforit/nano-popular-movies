package com.rabbit.green.movies.app.movies.details.list.reviews;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.rabbit.green.movies.app.BR;
import com.rabbit.green.movies.app.data.model.Review;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    private final ReviewViewModel viewModel;

    ReviewViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        viewModel = new ReviewViewModel();
        binding.setVariable(BR.vm, viewModel);
    }

    public void bind(Review review) {
        viewModel.setAuthor(review.getAuthor());
        viewModel.setContent(review.getContent());
    }
}
