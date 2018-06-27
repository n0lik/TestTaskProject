package com.test.testtaskproject.ui.worlds

import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferences
import com.test.testtaskproject.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldPresenter @Inject constructor(api: ServerApi, up: UserPreferences<User>):
        BasePresenterImpl<WorldView>(api, up){

    fun getWorlds(){
        getView()?.showLoading(true)
    }

}