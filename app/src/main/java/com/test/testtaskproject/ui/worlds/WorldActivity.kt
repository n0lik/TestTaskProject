package com.test.testtaskproject.ui.worlds

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.test.testtaskproject.R
import com.test.testtaskproject.model.WorldModel
import com.test.testtaskproject.ui.base.BaseActivity
import kotlinx.android.synthetic.main.world_activity.*
import java.net.NetworkInterface
import java.util.*
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldActivity : BaseActivity(), WorldView {

    @Inject
    lateinit var worldPresenter: WorldPresenter

    @Inject
    lateinit var worldAdapter: WorldAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        worldPresenter.apply {
            bind(this@WorldActivity)
            getWorlds()
        }
    }

    @SuppressLint("ResourceType")
    override fun getLayoutId(): Int? = R.layout.world_activity

    override fun setupUi() {
        val lm = LinearLayoutManager(baseContext)
        with(worldView){
            layoutManager = lm
            addItemDecoration(DividerItemDecoration(baseContext, lm.orientation))
            adapter = worldAdapter
        }
    }

    override fun showLoading(show: Boolean) {
    }

    override fun showWorlds(list: List<WorldModel>, clear: Boolean) {
        worldAdapter.addItems(list, clear)
    }

    override fun onDestroy() {
        worldPresenter.unbind()
        super.onDestroy()
    }

    override fun getMac(): String {
        try {
            val all = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (!nif.name.equals("wlan0", ignoreCase = true)) continue

                val macBytes = nif.hardwareAddress ?: return ""

                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }

                if (res1.isNotEmpty()) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (ex: Exception) {
        }

        return "02:00:00:00:00:00"
    }
}