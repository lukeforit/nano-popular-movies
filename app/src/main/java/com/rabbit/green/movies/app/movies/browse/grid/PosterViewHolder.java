package com.rabbit.green.movies.app.movies.browse.grid;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rabbit.green.movies.app.BR;
import com.rabbit.green.movies.app.common.OnViewHolderClickListener;

public class PosterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final PosterViewModel viewModel;
    private final OnViewHolderClickListener onViewHolderClickListener;

    public PosterViewHolder(@NonNull ViewDataBinding binding,
                            @NonNull OnViewHolderClickListener listener) {
        super(binding.getRoot());
        binding.getRoot().setOnClickListener(this);
        onViewHolderClickListener = listener;
        viewModel = new PosterViewModel();
        binding.setVariable(BR.vm, viewModel);
    }

    public void bind(String posterUrl) {
        viewModel.setImageUrl(posterUrl);
    }

    @Override
    public void onClick(View v) {
        onViewHolderClickListener.onViewHolderClick(getAdapterPosition());
    }
}
