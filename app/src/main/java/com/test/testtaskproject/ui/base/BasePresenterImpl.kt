package com.test.testtaskproject.ui.base

import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferences
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
abstract class BasePresenterImpl<V: BaseView>
    constructor(val serverApi: ServerApi, val userPreferences: UserPreferences<User>): BasePresenter<V> {

    protected var compositeDisposable: CompositeDisposable? = null
    private var view: V? = null

    override fun bind(view: V) {
        this.view = view
        compositeDisposable = CompositeDisposable()
    }

    override fun unbind() {
        this.view = null
        compositeDisposable?.apply {
            if (!isDisposed) {
                this.dispose()
            }
        }
    }

    override fun getView(): V? = view
}