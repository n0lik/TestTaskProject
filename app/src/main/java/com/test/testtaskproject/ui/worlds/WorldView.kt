package com.test.testtaskproject.ui.worlds

import com.test.testtaskproject.model.WorldModel
import com.test.testtaskproject.ui.base.BaseView

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
interface WorldView: BaseView {

    fun showWorlds(list: List<WorldModel>, clear: Boolean)

    fun getMac(): String

}