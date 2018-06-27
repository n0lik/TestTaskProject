package com.test.testtaskproject.ui.base

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
interface BaseView {

    fun showMsg(idRes: Int)

    fun showError(t: Throwable)

    fun showError(idRes: Int)

    fun showLoading(show: Boolean)

    fun navigateToLoginScreen()

    fun navigateToMainScreen()

}