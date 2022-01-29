package com.anurag.spacexextraaedgetask.ui.spaceXRocketList

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.anurag.spacexextraaedgetask.databinding.ActivitySpaceXRocketListBinding
import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.ui.base.BaseActivity
import com.anurag.spacexextraaedgetask.ui.spaceXRocketDetails.SpaceXRocketDetailActivity
import com.anurag.spacexextraaedgetask.ui.spaceXRocketList.adapter.RocketListAdapter
import com.anurag.spacexextraaedgetask.utlis.State
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

/**
 * Activity which show list of Rockets.
 */

@AndroidEntryPoint
class SpaceXRocketListActivity :
    BaseActivity<SpaceXRocketListViewModel, ActivitySpaceXRocketListBinding>(),
    RocketListAdapter.RocketItemListener {

    override val viewModel: SpaceXRocketListViewModel by viewModels()

    private lateinit var adapter: RocketListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        setupObservers()
        initView()

    }

    private fun initView() {
        getRockets()
    }

    private fun getRockets() = viewModel.getRockets()

    override fun onStart() {
        super.onStart()
        initView()
    }

    override fun getViewBinding() = ActivitySpaceXRocketListBinding.inflate(layoutInflater)

    private fun setupRecyclerView() {
        adapter = RocketListAdapter(this)
        binding.run {
            rvRocket.layoutManager = LinearLayoutManager(baseContext)
            rvRocket.adapter = adapter
        }

    }

    private fun setupObservers() {
        viewModel.rockets.observe(this) { state ->
            when (state) {
                is State.Success -> {
                    if (state.data.isNotEmpty()) {
                        adapter.setRockets(state.data.toMutableList() as ArrayList<Rocket>)
                        //   showLoading(false)
                    }
                }
                is State.Error -> {
                    //    showToast(state.message)
                    //  showLoading(false)
                }
            }
        }


    }


    override fun onClickedRocket(id: String) {
        val intent = Intent(this, SpaceXRocketDetailActivity::class.java)
        intent.putExtra("ID",id)
        startActivity(intent)
    }

}