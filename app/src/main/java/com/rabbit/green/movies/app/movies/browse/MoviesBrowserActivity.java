package com.rabbit.green.movies.app.movies.browse;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.data.model.MoviesRequest;
import com.rabbit.green.movies.app.databinding.ActivityMoviesBrowserBinding;
import com.rabbit.green.movies.app.movies.BaseActivity;

import org.parceler.Parcels;

public class MoviesBrowserActivity
        extends BaseActivity<MoviesBrowserPresenter, ActivityMoviesBrowserBinding> {

    private static final String BUNDLE_KEY_PARAMS = "BUNDLE_KEY_PARAMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setup();
        if (savedInstanceState != null) {
            Parcelable parcelable = savedInstanceState.getParcelable(BUNDLE_KEY_PARAMS);
            if (parcelable != null) {
                presenter.restoreData(Parcels.<MoviesRequest>unwrap(parcelable));
            }
        }
        presenter.loadData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movies_browser;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(BUNDLE_KEY_PARAMS, presenter.getParcelToSave());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //TODO figure out better way to handle menu in this architecture
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort_popularity) {
            presenter.displayPreferenceChanged(MoviesRequest.PREF_BY_POPULARITY);
            return true;
        } else if (item.getItemId() == R.id.action_sort_top_rated) {
            presenter.displayPreferenceChanged(MoviesRequest.PREF_BY_TOP_RATED);
            return true;
        } else if (item.getItemId() == R.id.action_favourites) {
            presenter.displayPreferenceChanged(MoviesRequest.PREF_FAVOURITES);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
