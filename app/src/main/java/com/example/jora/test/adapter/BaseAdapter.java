package com.example.jora.test.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by eugeniu on 1/3/17.
 */

public abstract class BaseAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {
    protected final String TAG = getClass().getSimpleName();
    protected List<T> itemList;

    protected BaseAdapter(List<T> itemList) {
        this.itemList = itemList;
    }

    BaseAdapter() {}

    @Override
    public int getItemCount() {
        return (itemList != null) ? itemList.size() : 0;
    }

    protected List<T> getData() {
        return itemList;
    }

    public void resetItems(List<T> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public void addItems(List<T> itemList) {
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void add(T item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void add(int index, T item) {
        itemList.add(index, item);
        notifyDataSetChanged();
    }

    public void update(T item, int index) {
        itemList.set(index, item);
        notifyDataSetChanged();
    }

    public T get(int index) {
        return itemList.get(index);
    }

    public void remove(int index) {
        itemList.remove(index);
        notifyDataSetChanged();
    }

    public void remove(T item) {
        itemList.remove(item);
        notifyDataSetChanged();
    }

    public void clear() {
        itemList.clear();
        notifyDataSetChanged();
    }
}
