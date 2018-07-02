package com.test.testtaskproject.ui.worlds

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.test.testtaskproject.R
import com.test.testtaskproject.model.WorldModel
import com.test.testtaskproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.world_fragment.*
import java.net.NetworkInterface
import java.util.*
import javax.inject.Inject

/**
 * Created by Sergey Shvets on 02/07/2018.
 */
class WorldFragment: BaseFragment(), WorldView {

    @Inject
    lateinit var worldPresenter: WorldPresenter

    private val worldAdapter: WorldAdapter = WorldAdapter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        worldPresenter.apply {
            bind(this@WorldFragment)
            if(savedInstanceState == null){
                getWorlds()
            }
        }
    }

    override fun onDestroyView() {
        worldPresenter.unbind()
        super.onDestroyView()
    }

    override fun setupUi() {
        val lm = LinearLayoutManager(baseActivity)
        with(worldView){
            layoutManager = lm
            addItemDecoration(DividerItemDecoration(baseActivity, lm.orientation))
            adapter = worldAdapter
        }
    }

    override fun getLayoutId(): Int? = R.layout.world_fragment

    override fun showWorlds(list: List<WorldModel>, clear: Boolean) {
        worldAdapter.addItems(list, clear)
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