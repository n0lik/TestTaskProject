package com.test.testtaskproject.ui.login

import android.os.Handler
import com.test.testtaskproject.R
import com.test.testtaskproject.ui.base.BasePresenterImpl
import com.test.testtaskproject.utils.InputFieldValidator

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class LoginPresenter: BasePresenterImpl<LoginView>(){

    private val testLogin = "android.test@xyrality.com"
    private val testPassword = "password"

    fun login(email: String, pass: String){
        getView()?.showLoading(true)
        if(checkEmail(email) && checkPass(pass)) {
            if (email == testLogin && pass == testPassword) {
                Handler().postDelayed({
                    getView()?.apply {
                        showLoading(false)
                        navigateToMainScreen()
                    }

                }, 2000)
            } else {
                getView()?.apply {
                    showLoading(false)
                    showMsg(R.string.alert_invalid_credential)
                }
            }
        } else {
            getView()?.apply {
                showLoading(false)
                showEmailValidError(InputFieldValidator.checkEmailValid(email))
                showPassValidError(InputFieldValidator.checkPasswordValid(pass))
            }
        }
    }

    private fun checkEmail(email: String): Boolean = InputFieldValidator.checkEmailValid(email) == null

    private fun checkPass(pass: String): Boolean = InputFieldValidator.checkPasswordValid(pass) == null

}