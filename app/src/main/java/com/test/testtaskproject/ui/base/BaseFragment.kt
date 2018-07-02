package com.test.testtaskproject.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment(), BaseView {

    var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity){
            baseActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getLayoutId()?.let {inflater.inflate(it, container, false)}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    abstract fun setupUi()

    protected abstract fun getLayoutId(): Int?

    override fun showMsg(idRes: Int) {
        baseActivity?.showMsg(idRes)
    }

    override fun showError(t: Throwable) {
        baseActivity?.showError(t)
    }

    override fun showError(idRes: Int) {
        baseActivity?.showError(idRes)
    }

    override fun showLoading(show: Boolean) {
        baseActivity?.showLoading(show)
    }

    override fun navigateToLoginScreen() {
        baseActivity?.navigateToLoginScreen()
    }

    override fun navigateToMainScreen() {
        baseActivity?.navigateToMainScreen()
    }

}