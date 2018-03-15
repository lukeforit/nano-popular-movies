package com.rabbit.green.movies.app.movies.details.list.reviews;

import android.databinding.BaseObservable;

@SuppressWarnings("WeakerAccess")
public class ReviewViewModel extends BaseObservable {

    private String author;
    private String content;

    public String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }
}
