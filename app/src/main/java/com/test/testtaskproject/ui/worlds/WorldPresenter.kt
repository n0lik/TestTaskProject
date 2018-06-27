package com.test.testtaskproject.ui.worlds

import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferences
import com.test.testtaskproject.ui.base.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldPresenter @Inject constructor(api: ServerApi, up: UserPreferences<User>):
        BasePresenterImpl<WorldView>(api, up){

    fun getWorlds(){
        getView()?.showLoading(true)
        userPreferences.getUser()?.apply {
            val map = HashMap<String, String>()
            map["login"] = email
            map["password"] = pass
            map["deviceType"] = deviceType
            map["deviceId"] = getView()!!.getMac()
            compositeDisposable!!.add(
                    serverApi.getUserWorlds(map)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                it.availableWorlds?.let {
                                    getView()?.apply {
                                        showWorlds(it, false)
                                        showLoading(false)
                                    }
                                }
                            },
                            {
                                getView()?.apply {
                                    showError(it)
                                    showLoading(false)
                                }
                            })
            )
        }
    }

}