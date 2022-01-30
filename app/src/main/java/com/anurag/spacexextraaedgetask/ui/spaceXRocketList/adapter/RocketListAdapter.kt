package com.anurag.spacexextraaedgetask.ui.spaceXRocketList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anurag.spacexextraaedgetask.databinding.SpacexRocketListItemBinding
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.ui.spaceXRocketList.viewHolder.RocketViewHolder

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

class RocketListAdapter(private val listener: RocketItemListener) :
    RecyclerView.Adapter<RocketViewHolder>() {

    private val rockets = ArrayList<Rocket>()

    interface RocketItemListener {
        fun onClickedRocket(id: String)
    }

    fun setRockets(items: ArrayList<Rocket>) {
        this.rockets.clear()
        this.rockets.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val binding: SpacexRocketListItemBinding = SpacexRocketListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RocketViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.bind(rockets[position])
    }

    override fun getItemCount() = rockets.size
}


