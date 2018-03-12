package com.rabbit.green.movies.app.movies.details;

import android.content.Intent;
import android.os.Bundle;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.databinding.ActivityMovieDetailsBinding;
import com.rabbit.green.movies.app.movies.BaseActivity;

import org.parceler.Parcels;

public class MovieDetailsActivity
        extends BaseActivity<MovieDetailsPresenter, ActivityMovieDetailsBinding> {

    public static final String BUNDLE_KEY_MOVIE = "BUNDLE_KEY_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setup();
        Intent intent = getIntent();
        if (intent.hasExtra(BUNDLE_KEY_MOVIE)) {
            presenter.loadData(Parcels.<Movie>unwrap(intent.getParcelableExtra(BUNDLE_KEY_MOVIE)));
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_details;
    }
}
