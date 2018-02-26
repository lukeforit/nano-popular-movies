package com.rabbit.green.movies.app.movies.browse.grid;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.rabbit.green.movies.app.BR;

public class PosterViewHolder extends RecyclerView.ViewHolder {

    private final PosterViewModel viewModel;

    public PosterViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        viewModel = new PosterViewModel();
        binding.setVariable(BR.vm, viewModel);
    }

    public void bind(String posterUrl) {
        viewModel.setImageUrl(posterUrl);
    }
}
