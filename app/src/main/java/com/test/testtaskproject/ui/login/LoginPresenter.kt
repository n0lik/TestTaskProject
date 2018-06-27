package com.test.testtaskproject.ui.login

import android.os.Handler
import com.test.testtaskproject.R
import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferences
import com.test.testtaskproject.ui.base.BasePresenterImpl
import com.test.testtaskproject.utils.InputFieldValidator
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class LoginPresenter @Inject constructor(api: ServerApi, up: UserPreferences<User>):
        BasePresenterImpl<LoginView>(api, up){

    private val testLogin = "android.test@xyrality.com"
    private val testPassword = "password"

    override fun bind(view: LoginView) {
        super.bind(view)
        if(userPreferences.isLogin()){
            getView()?.navigateToMainScreen()
        }
    }

    fun login(email: String, pass: String){
        getView()?.showLoading(true)
        if(checkEmail(email) && checkPass(pass)) {
            Handler().postDelayed({
                if (email == testLogin && pass == testPassword) {
                        getView()?.apply {
                            showLoading(false)
                            userPreferences.saveUser(User(email, pass, getDeviceType()))
                            navigateToMainScreen()
                        }
                } else {
                    getView()?.apply {
                        showLoading(false)
                        showMsg(R.string.alert_invalid_credential)
                    }
                }
                }, 4000)
        } else {
            getView()?.apply {
                showLoading(false)
                showEmailValidError(InputFieldValidator.checkEmailValid(email))
                showPassValidError(InputFieldValidator.checkPasswordValid(pass))
            }
        }
    }

    private fun getDeviceType(): String = String.format("%s %s", android.os.Build.MODEL, android.os.Build.VERSION.RELEASE)

    private fun checkEmail(email: String): Boolean = InputFieldValidator.checkEmailValid(email) == null

    private fun checkPass(pass: String): Boolean = InputFieldValidator.checkPasswordValid(pass) == null

}