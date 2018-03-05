package com.rabbit.green.movies.app.data.model;

import com.squareup.moshi.Json;

import java.util.List;

public class ReviewsResponse {
    private int id;
    private int page;
    private List<Review> results = null;
    @Json(name = "total_pages")
    private int totalPages;
    @Json(name = "total_results")
    private int totalResults;

    public ReviewsResponse(int id, int page, List<Review> results, int totalPages, int totalResults) {
        this.id = id;
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
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

    public List<Review> getResults() {
        return results;
    }

    public void setResults(List<Review> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
