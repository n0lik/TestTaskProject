package com.test.testtaskproject.ui.worlds

import com.test.testtaskproject.ui.base.BasePresenterImpl

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldPresenter: BasePresenterImpl<WorldView>(){

    fun getWorlds(){
        getView()?.showLoading(true)
    }

}