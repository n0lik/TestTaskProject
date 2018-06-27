package com.test.testtaskproject.ui.base

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.widget.Toast
import com.test.testtaskproject.ui.login.LoginActivity
import com.test.testtaskproject.ui.worlds.WorldActivity
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
abstract class BaseActivity: DaggerAppCompatActivity(), BaseView {

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
        val i = Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(i)
        this.finish()
    }

    override fun navigateToMainScreen() {
        val i = Intent(this, WorldActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(i)
        this.finish()
    }

}