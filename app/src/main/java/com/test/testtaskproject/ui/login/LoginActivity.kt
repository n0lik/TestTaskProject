package com.test.testtaskproject.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.test.testtaskproject.R
import com.test.testtaskproject.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 25/06/2018.
 */

class LoginActivity: BaseActivity(), LoginView, View.OnClickListener {

    private val LOADING_STATE = "Loading"
    private var LOAGING: Boolean = false

    @Inject
    lateinit var mLoginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoginPresenter.bind(this)
    }

    @SuppressLint("ResourceType")
    override fun getLayoutId(): Int? = R.layout.activity_login

    override fun setupUi() {
        email_sign_in_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.email_sign_in_button ->
                mLoginPresenter.login(email.text.toString(), password.text.toString())
        }
    }

    override fun showLoading(show: Boolean) {
        LOAGING = show
        login_progress.visibility = if(show) View.VISIBLE else View.GONE
        login_form.visibility =  if(!show) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(LOADING_STATE, LOAGING)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState?.getBoolean(LOADING_STATE) == true){
            mLoginPresenter.login(email.text.toString(), password.text.toString())
        }
    }

    override fun showEmailValidError(resError: Int?) {
        resError?.let { email.error = resources.getString(it) }
    }

    override fun showPassValidError(resError: Int?) {
        resError?.let { password.error = resources.getString(it) }
    }

    override fun onDestroy() {
        mLoginPresenter.unbind()
        super.onDestroy()
    }

}