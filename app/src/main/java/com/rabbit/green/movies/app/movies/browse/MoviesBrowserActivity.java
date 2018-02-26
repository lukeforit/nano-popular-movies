package com.rabbit.green.movies.app.movies.browse;

import android.os.Bundle;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.databinding.ActivityMoviesBrowserBinding;
import com.rabbit.green.movies.app.movies.BaseActivity;

public class MoviesBrowserActivity
        extends BaseActivity<MoviesBrowserPresenter, ActivityMoviesBrowserBinding> {

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
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                startActivity(new Intent(getApplicationContext(), MovieDetailsActivity.class));
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movies_browser;
    }

}
