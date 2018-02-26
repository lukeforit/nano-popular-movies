package com.rabbit.green.movies.app.common;

import android.content.Context;
import android.support.annotation.StringRes;

public class ContextUtils {
    private final Context context;

    public ContextUtils(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public String getString(@StringRes int stringId) {
        return context.getString(stringId);
    }
}
