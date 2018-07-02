package com.test.testtaskproject.ui.worlds

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.test.testtaskproject.R
import com.test.testtaskproject.model.WorldModel
import com.test.testtaskproject.ui.base.BaseActivity
import com.test.testtaskproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.world_activity.*
import java.net.NetworkInterface
import java.util.*
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldActivity : BaseActivity() {

    @SuppressLint("ResourceType")
    override fun getLayoutId(): Int? = R.layout.world_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?:apply {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, WorldFragment())
                    .commit()
        }
    }

    override fun setupUi() {}

    override fun showLoading(show: Boolean) {
    }

}