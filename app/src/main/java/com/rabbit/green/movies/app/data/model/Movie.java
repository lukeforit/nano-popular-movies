package com.rabbit.green.movies.app.data.model;

public class Movie {
    public static final String EXTRAS_MOVIE_ID     = "com.green.rabbit.movies.ID";
    public static final String EXTRAS_MOVIE_POSTER = "com.green.rabbit.movies.POSTER";

    private long mId;
    private String mTitle;
    private String mReleaseDate;
    private String mPlot;
    private double mVoteAvg;
    private String mPoster;

    public Movie(long mId, String mTitle, String mReleaseDate, String mPlot, double mVoteAvg, String mPoster) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mReleaseDate = mReleaseDate;
        this.mPlot = mPlot;
        this.mVoteAvg = mVoteAvg;
        this.mPoster = mPoster;
    }
    public Movie(long mId, String mPoster) {
        this.mId = mId;
        this.mPoster = mPoster;
    }

    public long getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public String getmPlot() {
        return mPlot;
    }

    public double getmVoteAvg() {
        return mVoteAvg;
    }

    public String getmPoster() {
        return mPoster;
    }
}
