package com.test.testtaskproject.ui.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {

    private val list = ArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false)
        return createViewHolder(view)
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun createViewHolder(view: View): BaseViewHolder<T>

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(list[position])
    }

}