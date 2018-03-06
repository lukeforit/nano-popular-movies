package com.rabbit.green.movies.app.movies.details.list.videos;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.rabbit.green.movies.app.BR;
import com.rabbit.green.movies.app.data.model.Video;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private VideoViewModel viewModel;

    VideoViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        viewModel = new VideoViewModel();
        binding.setVariable(BR.vm, viewModel);
    }

    public void bind(Video video) {
        viewModel.setTitle(video.getName());
    }
}
