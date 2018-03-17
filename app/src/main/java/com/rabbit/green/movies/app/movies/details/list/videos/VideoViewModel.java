package com.rabbit.green.movies.app.movies.details.list.videos;

import android.databinding.BaseObservable;

@SuppressWarnings("WeakerAccess")
public class VideoViewModel extends BaseObservable {
    private String title;
    private String videoUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
