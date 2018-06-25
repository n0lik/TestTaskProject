package com.test.testtaskproject.ui

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
interface BaseView {

    fun showMsg(idRes: Int)

    fun showError(t: Throwable)

    fun showLoading(show: Boolean)

    fun navigateToLoginScreen()

    fun navigateToMainScreen()

}