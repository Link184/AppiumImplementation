package com.example.jora.test

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.jora.test.adapter.AbstractAdapter

/**
 * Created by jora on 1/16/18.
 */
/**
 * Some extension sugar which will help us to setup RecyclerView, designed only for adapters with
 * one view type.
 * @param items a list of items which should work with our adapter
 * @param layoutResId a layout res id which shout work with our adapter
 * @param bindHolder a callback which will be called for adapters onBindViewHolder() method.
 * @param manager optional LinearLayoutManager
 */
fun <T> RecyclerView.setUp(items: List<T>,
                              layoutResId: Int,
                              bindHolder: View.(T) -> Unit,
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)): AbstractAdapter<T> {

    return AbstractAdapter(items, layoutResId, {
        bindHolder(it)
    }).apply {
        layoutManager = manager
        adapter = this
    }
}