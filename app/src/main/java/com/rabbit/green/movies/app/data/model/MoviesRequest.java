package com.rabbit.green.movies.app.data.model;

public class MoviesRequest {
    private int page;

    public MoviesRequest(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
