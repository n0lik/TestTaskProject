package com.test.testtaskproject.ui.base

import android.accounts.AuthenticatorException
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import com.test.testtaskproject.R
import com.test.testtaskproject.ui.login.LoginActivity
import com.test.testtaskproject.ui.worlds.WorldActivity
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.HttpException
import java.net.UnknownHostException

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
        var message: Int = R.string.exception_message_generic
        when(t) {
            is HttpException -> {
                if (t.response() != null && t.response().code() == 404) {
                    R.string.exception_message_not_found_web_data_error
                } else if (t.response() != null && t.response().code() == 400) {
                    R.string.alert_invalid_credential
                } else {
                    R.string.exception_message_loading_web_data_error
                }
            }
            is UnknownHostException ->  {
                R.string.exception_message_internet_connection_error
            }
            is AuthenticatorException ->  {
                R.string.alert_invalid_credential
            }
        }
        showError(message)
    }

    override fun showError(idRes: Int) {
        val root = window.decorView.findViewById(android.R.id.content) as View
        Snackbar.make(root, idRes, Snackbar.LENGTH_LONG).show()
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