package com.anurag.spacexextraaedgetask.ui.spaceXRocketList

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.anurag.spacexextraaedgetask.R
import com.anurag.spacexextraaedgetask.databinding.ActivitySpaceXRocketListBinding
import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.ui.base.BaseActivity
import com.anurag.spacexextraaedgetask.ui.spaceXRocketDetails.SpaceXRocketDetailActivity
import com.anurag.spacexextraaedgetask.ui.spaceXRocketList.adapter.RocketListAdapter
import com.anurag.spacexextraaedgetask.utlis.NetworkUtils
import com.anurag.spacexextraaedgetask.utlis.State
import com.anurag.spacexextraaedgetask.utlis.getColorRes
import com.anurag.spacexextraaedgetask.utlis.show
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
    }

    private fun getRockets() = viewModel.getRockets()

    override fun onStart() {
        super.onStart()
        handleNetworkChanges()
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

    /**
     * Observe network changes i.e. Internet Connectivity
     */
    private fun handleNetworkChanges() {
        NetworkUtils.getNetworkLiveData(applicationContext).observe(this) { isConnected ->
            if (!isConnected) {
                binding.textViewNetworkStatus.text =
                    getString(R.string.text_no_connectivity)
                binding.networkStatusLayout.apply {
                    show()
                    setBackgroundColor(getColorRes(R.color.statusNotConnectedColor))
                }
            } else {
                if (adapter.itemCount == 0) getRockets()
                binding.textViewNetworkStatus.text = getString(R.string.text_connectivity)
                binding.networkStatusLayout.apply {
                    setBackgroundColor(getColorRes(R.color.statusConnectedColor))
                }
            }
        }
    }

}