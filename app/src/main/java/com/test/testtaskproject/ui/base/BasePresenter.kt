package com.test.testtaskproject.ui.base

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
interface BasePresenter<T: BaseView> {

    fun bind(view: T)

    fun unbind()

    fun getView(): T?

}