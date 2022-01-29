package com.anurag.spacexextraaedgetask.ui.spaceXRocketList

import android.os.Bundle
import androidx.activity.viewModels
import com.anurag.spacexextraaedgetask.databinding.ActivitySpaceXRocketListBinding
import com.anurag.spacexextraaedgetask.ui.base.BaseActivity
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
    BaseActivity<SpaceXRocketListViewModel, ActivitySpaceXRocketListBinding>() {

    override val viewModel: SpaceXRocketListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()

        binding.textView.setOnClickListener{
            getRockets()
        }

    }

    private fun initView() {

    }

    private fun getRockets() = viewModel.getRockets()

    override fun onStart() {
        super.onStart()
    }

    override fun getViewBinding() = ActivitySpaceXRocketListBinding.inflate(layoutInflater)


}