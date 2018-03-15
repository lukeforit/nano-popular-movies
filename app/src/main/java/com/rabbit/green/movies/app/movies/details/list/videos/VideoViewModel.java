package com.rabbit.green.movies.app.movies.details.list.videos;

import android.databinding.BaseObservable;

@SuppressWarnings("WeakerAccess")
public class VideoViewModel extends BaseObservable {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
