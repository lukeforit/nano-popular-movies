package com.rabbit.green.movies.app.movies.details;

import android.os.Bundle;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.databinding.ActivityMovieDetailsBinding;
import com.rabbit.green.movies.app.movies.BaseActivity;

public class MovieDetailsActivity
        extends BaseActivity<MovieDetailsPresenter, ActivityMovieDetailsBinding> {

    public static final String BUNDLE_KEY_MOVIE = "BUNDLE_KEY_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_details;
    }

}
