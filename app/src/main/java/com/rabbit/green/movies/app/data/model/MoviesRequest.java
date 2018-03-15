package com.rabbit.green.movies.app.data.model;

import org.parceler.Parcel;

@SuppressWarnings("WeakerAccess")
@Parcel(Parcel.Serialization.BEAN)
public class MoviesRequest {
    private int page;
    private int displayPreference;

    public static final int PREF_BY_POPULARITY = 0;
    public static final int PREF_BY_TOP_RATED = 1;
    public static final int PREF_FAVOURITES = 2;

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SORT = PREF_BY_POPULARITY;

    public MoviesRequest() {
        this(DEFAULT_PAGE, DEFAULT_SORT);
    }

    @SuppressWarnings("SameParameterValue")
    private MoviesRequest(int page, int displayPreference) {
        this.page = page;
        this.displayPreference = displayPreference;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getDisplayPreference() {
        return displayPreference;
    }

    public void setDisplayPreference(int displayPreference) {
        this.displayPreference = displayPreference;
    }

    public void resetPage() {
        page = DEFAULT_PAGE;
    }

    public void incrementPage() {
        ++page;
    }
}
