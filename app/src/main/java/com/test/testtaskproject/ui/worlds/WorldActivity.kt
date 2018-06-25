package com.test.testtaskproject.ui.worlds

import android.annotation.SuppressLint
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.test.testtaskproject.R
import com.test.testtaskproject.model.WorldModel
import com.test.testtaskproject.ui.base.BaseActivity
import kotlinx.android.synthetic.main.world_activity.*

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldActivity : BaseActivity(), WorldView {

    private val worldAdapter = WorldAdapter()

    @SuppressLint("ResourceType")
    override fun getLayoutId(): Int? = R.layout.world_activity

    override fun setupUi() {
        val lm = LinearLayoutManager(baseContext)
        val itemDecor = DividerItemDecoration(baseContext, lm.orientation)
        worldView.apply {
            layoutManager = lm
            addItemDecoration(itemDecor)
            adapter = worldAdapter
        }
    }

    override fun showLoading(show: Boolean) {
    }

    override fun showWorlds(list: List<WorldModel>, clear: Boolean) {
        worldAdapter.addItems(list, clear)
    }

}