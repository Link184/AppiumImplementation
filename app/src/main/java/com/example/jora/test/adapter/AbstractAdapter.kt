package com.example.jora.test.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jora on 1/16/18.
 */
open class AbstractAdapter<T> constructor(
        protected var items: List<T>,
        private val layoutResId: Int,
        private val bindHolder: View.(T) -> Unit)
    : BaseAdapter<T, RecyclerView.ViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val viewHolder = object : RecyclerView.ViewHolder(view){}
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
            }
        }
        return viewHolder
    }

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.bindHolder(items[position])
    }
}