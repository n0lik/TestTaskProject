package com.test.testtaskproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
abstract class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let {
            setContentView(it)
            setupUi()
        }
    }

    @IdRes
    protected abstract fun getLayoutId(): Int?

    protected abstract fun setupUi()

    @SuppressLint("ResourceType")
    override fun showMsg(@IdRes idRes: Int) {
        Toast.makeText(this@BaseActivity, idRes, Toast.LENGTH_LONG).show()
    }

    override fun showError(t: Throwable) {
    }

    override fun navigateToLoginScreen() {
    }

    override fun navigateToMainScreen() {
    }

}