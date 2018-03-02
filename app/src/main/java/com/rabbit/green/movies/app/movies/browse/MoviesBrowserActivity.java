package com.rabbit.green.movies.app.movies.browse;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.databinding.ActivityMoviesBrowserBinding;
import com.rabbit.green.movies.app.movies.BaseActivity;

public class MoviesBrowserActivity
        extends BaseActivity<MoviesBrowserPresenter, ActivityMoviesBrowserBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movies_browser;
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
        if (item.getItemId() == R.id.action_sort) {
            if (presenter.sortOrderChanged()) {
                item.setTitle(R.string.action_sort_popularity);
                item.setIcon(R.drawable.ic_trending_up_white);
            } else {
                item.setTitle(R.string.action_sort_top_rated);
                item.setIcon(R.drawable.ic_star_white);
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
