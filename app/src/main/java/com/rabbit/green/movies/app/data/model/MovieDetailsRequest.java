package com.rabbit.green.movies.app.data.model;

public class MovieDetailsRequest {
    private int id;
    private int page;

    private static final int DEFAULT_PAGE = 1;

    public MovieDetailsRequest(int id) {
        this.id = id;
        this.page = DEFAULT_PAGE;
    }

    public MovieDetailsRequest(int id, int page) {
        this.id = id;
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
