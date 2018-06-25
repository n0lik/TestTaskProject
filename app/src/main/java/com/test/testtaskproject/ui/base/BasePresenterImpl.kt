package com.test.testtaskproject.ui.base

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
abstract class BasePresenterImpl<V: BaseView>: BasePresenter<V> {

    private var view: V? = null

    override fun bind(view: V) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override fun getView(): V? = view
}