package com.rabbit.green.movies.app.common;

import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder, D>
        extends RecyclerView.Adapter<VH> {

    protected List<D> data;

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void addData(List<D> data) {
        if (this.data == null) {
            this.data = data;
        } else {
            this.data.addAll(data);
        }
        notifyItemRangeInserted(this.data.size() - data.size(), data.size());
    }

    public void clear() {
        if (data != null) {
            int oldSize = data.size();
            data.clear();
            notifyItemRangeRemoved(0, oldSize);
        }
    }

    public List<D> getData() {
        return data;
    }
}
