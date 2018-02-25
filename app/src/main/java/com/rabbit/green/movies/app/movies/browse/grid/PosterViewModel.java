package com.rabbit.green.movies.app.movies.browse.grid;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.rabbit.green.movies.app.BR;
import com.rabbit.green.movies.app.R;
import com.squareup.picasso.Picasso;

public class PosterViewModel extends BaseObservable {
    private String imageUrl;

    public PosterViewModel() {
    }

    public PosterViewModel(String url) {
        this.imageUrl = url;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
        notifyPropertyChanged(BR.imageUrl);
    }

    @BindingAdapter("url")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_update_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp)
                .into(view);
    }
}
