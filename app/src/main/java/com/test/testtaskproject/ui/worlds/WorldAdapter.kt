package com.test.testtaskproject.ui.worlds

import android.view.View
import com.test.testtaskproject.R
import com.test.testtaskproject.model.WorldModel
import com.test.testtaskproject.ui.base.BaseAdapter
import com.test.testtaskproject.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_world.view.*

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldAdapter: BaseAdapter<WorldModel>() {

    override fun getLayoutId(): Int = R.layout.item_world

    override fun createViewHolder(view: View): BaseViewHolder<WorldModel> = WorldViewHolder(view)

    inner class WorldViewHolder(itemView: View): BaseViewHolder<WorldModel>(itemView){

        override fun bind(item: WorldModel) = with(itemView){
            itemView.nameTextView.text = item.name
        }

    }

}