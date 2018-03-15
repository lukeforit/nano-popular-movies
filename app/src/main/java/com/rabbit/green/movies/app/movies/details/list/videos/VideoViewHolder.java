package com.rabbit.green.movies.app.movies.details.list.videos;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rabbit.green.movies.app.BR;
import com.rabbit.green.movies.app.common.OnViewHolderClickListener;
import com.rabbit.green.movies.app.data.model.Video;

public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final VideoViewModel viewModel;

    private final OnViewHolderClickListener listener;

    VideoViewHolder(@NonNull ViewDataBinding binding, @NonNull OnViewHolderClickListener listener) {
        super(binding.getRoot());
        this.listener = listener;
        viewModel = new VideoViewModel();
        binding.setVariable(BR.vm, viewModel);
        binding.setVariable(BR.cb, this);
    }

    public void bind(Video video) {
        viewModel.setTitle(video.getName());
    }

    @Override
    public void onClick(View v) {
        listener.onViewHolderClick(getAdapterPosition());
    }
}
