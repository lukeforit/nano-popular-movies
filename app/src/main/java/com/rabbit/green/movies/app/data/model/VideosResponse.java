package com.rabbit.green.movies.app.data.model;

import java.util.List;

@SuppressWarnings("unused")
public class VideosResponse {
    private int id;
    private List<Video> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }
}
