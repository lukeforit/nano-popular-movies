package com.rabbit.green.movies.app.movies.details;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.databinding.ActivityMovieDetailsBinding;
import com.rabbit.green.movies.app.movies.BaseActivity;

import org.parceler.Parcels;

public class MovieDetailsActivity
        extends BaseActivity<MovieDetailsPresenter, ActivityMovieDetailsBinding> {

    public static final String BUNDLE_KEY_MOVIE = "BUNDLE_KEY_MOVIE";
    public static final String BUNDLE_KEY_VIDEOS_ML_STATE = "BUNDLE_KEY_MOVIE";
    public static final String BUNDLE_KEY_REVIEWS_LM_STATE = "BUNDLE_KEY_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setup();
        Intent intent = getIntent();
        if (intent.hasExtra(BUNDLE_KEY_MOVIE)) {
            presenter.loadData(Parcels.<Movie>unwrap(intent.getParcelableExtra(BUNDLE_KEY_MOVIE)));
        }

        //Execute pending bindings before accessing LayoutManager
        binding.executePendingBindings();
        if (savedInstanceState != null) {
            Parcelable videosParcel = savedInstanceState.getParcelable(BUNDLE_KEY_VIDEOS_ML_STATE);
            if (videosParcel != null) {
                binding.videosRv.getLayoutManager().onRestoreInstanceState(videosParcel);
            }
            Parcelable reviewsParcel = savedInstanceState.getParcelable(BUNDLE_KEY_REVIEWS_LM_STATE);
            if (reviewsParcel != null) {
                binding.reviewsRv.getLayoutManager().onRestoreInstanceState(reviewsParcel);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(BUNDLE_KEY_VIDEOS_ML_STATE,
                binding.videosRv.getLayoutManager().onSaveInstanceState());
        outState.putParcelable(BUNDLE_KEY_REVIEWS_LM_STATE,
                binding.reviewsRv.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
        presenter.cacheData();
    }

    @Override
    public void onBackPressed() {
        presenter.invalidateCache();
        super.onBackPressed();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_details;
    }
}
