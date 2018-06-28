package com.test.testtaskproject

import com.nhaarman.mockito_kotlin.then
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferencesImpl
import com.test.testtaskproject.ui.login.LoginPresenter
import com.test.testtaskproject.ui.login.LoginView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Sergey Shvets on 28/06/2018.
 */
class LoginPresenterTest {

    private lateinit var mockLoginView: LoginView
    private lateinit var mockLoginPresenter: LoginPresenter
    private lateinit var mockApi: ServerApi
    private lateinit var mockUserPreferences: UserPreferencesImpl

    @Before
    fun setup(){
        mockLoginView = Mockito.mock(LoginView::class.java)
        mockApi = Mockito.mock(ServerApi::class.java)
        mockUserPreferences = Mockito.mock(UserPreferencesImpl::class.java)
        mockLoginPresenter = LoginPresenter(mockApi, mockUserPreferences)
    }

    @Test
    fun test_bind_view(){
        mockLoginPresenter.bind(mockLoginView)
        Assert.assertEquals(mockLoginPresenter.getView(), mockLoginView)
    }

    @Test
    fun test_unbind_view(){
        mockLoginPresenter.bind(mockLoginView)
        mockLoginPresenter.unbind()
        Assert.assertNull(mockLoginPresenter.getView())
    }

    @Test
    fun test_check_user_is_login_after_binding(){
        mockLoginPresenter.bind(mockLoginView)
        then(mockUserPreferences).should().isLogin()
    }

}