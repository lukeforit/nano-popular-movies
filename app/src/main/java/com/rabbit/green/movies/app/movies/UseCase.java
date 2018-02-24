package com.rabbit.green.movies.app.movies;

import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<RESPONSE, REQUEST>
        implements SingleObserver<RESPONSE>, Callable<RESPONSE> {

    protected REQUEST parameters;

    public void execute(REQUEST parameters) {
        this.parameters = parameters;
        Single.fromCallable(this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public abstract void onSuccess(RESPONSE response);

    @Override
    public void onError(Throwable e) {
        onError();
    }

    public abstract void onError();

    @Override
    public abstract RESPONSE call() throws Exception;
}
