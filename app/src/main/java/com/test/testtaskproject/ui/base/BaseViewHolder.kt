package com.test.testtaskproject.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){

    abstract fun bind(item: T)

}