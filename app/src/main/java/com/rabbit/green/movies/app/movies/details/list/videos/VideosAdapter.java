package com.rabbit.green.movies.app.movies.details.list.videos;

import android.content.ActivityNotFoundException;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.BaseAdapter;
import com.rabbit.green.movies.app.common.ContextUtils;
import com.rabbit.green.movies.app.common.OnViewHolderClickListener;
import com.rabbit.green.movies.app.data.model.Video;

import javax.inject.Inject;

public class VideosAdapter extends BaseAdapter<VideoViewHolder, Video>
        implements OnViewHolderClickListener {

    @SuppressWarnings("WeakerAccess")
    @Inject
    ContextUtils contextUtils;

    @Inject
    VideosAdapter() {
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item_video, parent, false);
        return new VideoViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public void onViewHolderClick(int position) {
        try {
            contextUtils.runYouTubeApp(data.get(position).getKey());
        } catch (ActivityNotFoundException e) {
            contextUtils.runYouTubeInBrowser(data.get(position).getKey());
        }
    }
}
