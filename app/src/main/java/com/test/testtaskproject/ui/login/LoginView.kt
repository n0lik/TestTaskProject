package com.test.testtaskproject.ui.login

import android.support.annotation.IdRes
import com.test.testtaskproject.ui.base.BaseView

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
interface LoginView : BaseView {

    fun showEmailValidError(@IdRes resError: Int?)

    fun showPassValidError(@IdRes resError: Int?)

}