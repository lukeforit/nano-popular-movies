package com.rabbit.green.movies.app.movies.browse;

import android.support.v7.widget.GridLayoutManager;

import com.rabbit.green.movies.app.R;
import com.rabbit.green.movies.app.common.ContextUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesBrowserModule {

    @Provides
    public GridLayoutManager provideGridLayoutManager(ContextUtils contextUtils) {
        return new GridLayoutManager(contextUtils.getContext(),
                contextUtils.getInteger(R.integer.grid_columns_number));
    }
}
