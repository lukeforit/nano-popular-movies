package com.rabbit.green.movies.app.movies;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import .BR;
import dagger.android.AndroidInjection;

@SuppressLint("Registered")
public abstract class BaseActivity<
        P extends BasePresenter,
        B extends ViewDataBinding> extends AppCompatActivity {

    @Inject
    protected P presenter;

    B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        bind();
    }

    @LayoutRes
    protected abstract int getLayoutId();

    private void bind() {
        binding.setVariable(BR.vm, presenter.getViewModel());
    }
}
