package com.anurag.spacexextraaedgetask.ui.spaceXRocketList.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.anurag.spacexextraaedgetask.databinding.SpacexRocketListItemBinding
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.ui.spaceXRocketList.adapter.RocketListAdapter
import com.bumptech.glide.Glide

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

class RocketViewHolder(
    private val itemBinding: SpacexRocketListItemBinding,
    private val listener: RocketListAdapter.RocketItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var rocket: Rocket
    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(rocket: Rocket) {
        this.rocket = rocket
        itemBinding.tvRocketName.text = rocket.name
        itemBinding.tvStats.text = if(rocket.active == true) {
            "Active"
        }else{
            "Not Active"
        }
        itemBinding.tvCompanyName.text = rocket.company
            Glide.with(itemBinding.root)
                .load(rocket.flickrImages[0])
                .into(itemBinding.ivRocket)
    }

    override fun onClick(v: View?) {
        listener.onClickedRocket(rocket.id)
    }
}