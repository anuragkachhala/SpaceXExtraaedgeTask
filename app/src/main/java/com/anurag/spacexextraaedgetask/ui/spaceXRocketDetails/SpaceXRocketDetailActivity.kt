package com.anurag.spacexextraaedgetask.ui.spaceXRocketDetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.anurag.spacexextraaedgetask.R
import com.anurag.spacexextraaedgetask.databinding.ActivitySpaceXrocketDetailBinding
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.ui.base.BaseActivity
import com.anurag.spacexextraaedgetask.utlis.State
import com.bumptech.glide.Glide
import com.synnapps.carouselview.ImageListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SpaceXRocketDetailActivity :
    BaseActivity<SpaceXRocketDetailViewModel, ActivitySpaceXrocketDetailBinding>() {

    override val viewModel: SpaceXRocketDetailViewModel by viewModels()

    private var flickerImages: List<String> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val id = intent.getStringExtra("ID")

        setupObservers()
        if (id != null) {
            initView(id)
        }
    }

    private fun initView(id: String) {
        id.let { viewModel.start(it) }
    }

    private fun setUpCarouselView(flickerImages: List<String>) {
        binding.carouselView.run {
            pageCount = flickerImages.size
            setImageListener(imageListener)
        }

    }

    private var imageListener =
        ImageListener { position, imageView ->
            Glide.with(binding.root)
                .load(flickerImages[position])
                .into(imageView)
        }

    private fun setupObservers() {
        viewModel.rocket.observe(this) { rocket ->
            setRocketData(rocket)
        }
    }

    private fun setRocketData(rocket: Rocket?) {
        flickerImages = rocket?.flickrImages ?: emptyList()
        setUpCarouselView(flickerImages)
        setUpRocketInfo(rocket)
        setUpRocketDescription(rocket)
        setUpRocketSpecification(rocket)
        setUpStagesInfo(rocket)
        setUpEnginInfo(rocket)
        binding.let {
        }
    }

    /**
     * Method setup Rocket Basic Info
     */
    private fun setUpRocketInfo(rocket: Rocket?) {
        binding.run {
            tvRocketName.text = rocket?.name
            tvType.text = rocket?.type
            tvStatus.text = if (rocket?.active == true) {
                getString(R.string.rocket_status_active)
            } else {
                getString(R.string.rocket_status_inactive)
            }
        }
    }

    /**
     * Method setup Rocket Description
     */
    private fun setUpRocketDescription(rocket: Rocket?) {
        binding.run {
            tvCompanyName.text = rocket?.company
            "${getString(R.string.dollar_text)} ${rocket?.costPerLaunch}".also {
                tvLauchCost.text = it
            }
            "${rocket?.stages} Stages".also { tvStages.text = it }
            tvFirstLaunch.text = rocket?.firstFlight
            description.text = rocket?.description
            //
        }
    }

    /**
     * Method setup Rocket Specification
     */
    @SuppressLint("SetTextI18n")
    private fun setUpRocketSpecification(rocket: Rocket?) {
        binding.run {
            //specification
            tvHeight.text = "${rocket?.height?.meters} m - ${rocket?.height?.feet} ft"
            tvDiameter.text = "${rocket?.diameter?.meters} m - ${rocket?.diameter?.feet} ft"
            tvWeight.text = "${rocket?.mass?.kg} Kg -${rocket?.mass?.lb} Lb"
            tvFairingHeight.text =
                "${rocket?.secondStage?.payloads?.compositeFairing?.height?.meters} m"
            tvFairingDiameter.text =
                "${rocket?.secondStage?.payloads?.compositeFairing?.diameter?.meters} m"


            tvOrbit.text = "${rocket?.payloadWeights?.get(0)?.kg} Kg"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUpEnginInfo(rocket: Rocket?) {

        binding.run {
            tvModel.text = "${rocket?.engines?.type} ${rocket?.engines?.version}"
            tvThrustWeight.text = "${rocket?.engines?.thrustToWeight}"
            tvFuel.text = "${rocket?.engines?.propellant2}"
            tvOxidizer.text = "${rocket?.engines?.propellant1}"
            tvSeaLevelThrust.text = "${rocket?.engines?.thrustSeaLevel?.kN} KN"
            tvVacuumThrust.text = "${rocket?.engines?.thrustVacuum?.kN} KN"
            tvSeaLeveIsp.text = "${rocket?.engines?.isp?.seaLevel} s"
            tvVacuumIsp.text = "${rocket?.engines?.isp?.vacuum} s"
        }
    }

    /**
     * Method setup Rocket Stages Info
     */
    @SuppressLint("SetTextI18n")
    private fun setUpStagesInfo(rocket: Rocket?) {

        binding.run {
            tvFirstStageThrush.text = "${rocket?.firstStage?.thrustSeaLevel?.kN} KN"
            tvFuelAmount.text = "${rocket?.firstStage?.fuelAmountTons} Tons"
            tvEngines.text = "${rocket?.firstStage?.engines} Engine"
            tvReusable.text = if (rocket?.firstStage?.reusable == true) {
                getString(R.string.yes)
            } else {
                getString(R.string.no)
            }

            tvFirstStageThrush2.text = "${rocket?.secondStage?.thrust?.kN} KN"
            tvFuelAmount2.text = "${rocket?.secondStage?.fuelAmountTons} Tons"
            tvEngines2.text = "${rocket?.secondStage?.engines} Engine"
            tvReusable2.text = if (rocket?.firstStage?.reusable == true) {
                getString(R.string.yes)
            } else {
                getString(R.string.no)
            }
        }
    }


    override fun getViewBinding() = ActivitySpaceXrocketDetailBinding.inflate(layoutInflater)

}