package com.rabbit.green.movies.app.common;

import android.content.Context;

public class ContextUtils {
    private final Context context;

    public ContextUtils(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
