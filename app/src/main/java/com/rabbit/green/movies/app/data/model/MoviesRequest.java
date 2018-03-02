package com.rabbit.green.movies.app.data.model;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class MoviesRequest {
    private int page;
    private boolean sortByPopularity;

    public static final int DEFAULT_PAGE = 1;
    public static final boolean DEFAULT_SORT = true;

    public MoviesRequest() {
        this(DEFAULT_PAGE, DEFAULT_SORT);
    }

    public MoviesRequest(int page, boolean sortByPopularity) {
        this.page = page;
        this.sortByPopularity = sortByPopularity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isSortByPopularity() {
        return sortByPopularity;
    }

    public void setSortByPopularity(boolean sortByPopularity) {
        this.sortByPopularity = sortByPopularity;
    }

    public void reverseSort() {
        sortByPopularity = !sortByPopularity;
    }

    public void resetPage() {
        page = DEFAULT_PAGE;
    }
}
