package com.anurag.spacexextraaedgetask.ui.spaceXRocketDetails

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import com.anurag.spacexextraaedgetask.databinding.ActivitySpaceXrocketDetailBinding
import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.ui.base.BaseActivity
import com.anurag.spacexextraaedgetask.utlis.State
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SpaceXRocketDetailActivity :
    BaseActivity<SpaceXRocketDetailViewModel, ActivitySpaceXrocketDetailBinding>() {

    override val viewModel: SpaceXRocketDetailViewModel by viewModels()

    private var flickerImages : List<String> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val  id = intent.getStringExtra("ID");

        setupObservers()
        if (id != null) {
            initView(id)
        }
    }

    private fun initView(id: String){
        id.let { viewModel.getRocket(it) }
    }

    private fun setUpCarouselView(flickerImages: List<String>){
        binding.carouselView.run {
            pageCount = flickerImages.size
            setImageListener { position, imageView -> imageView.setImageURI(Uri.parse(flickerImages[position])) }
        }
    }

    private fun setupObservers() {
        viewModel.rocket.observe(this) { state ->
            when (state) {
                is State.Success -> {
                   setRocketData(state.data)
                }
                is State.Error -> {
                    //    showToast(state.message)
                    //  showLoading(false)
                }
            }
        }
    }


    private fun setRocketData(rocket: Rocket?){
        flickerImages = rocket?.flickrImages?: emptyList()
      //  setUpCarouselView(flickerImages)
        binding.let {
            it.tvRocketName.text = rocket?.name
            it.tvType.text = rocket?.type
            it.tvStatus.text = if(rocket?.active == true) {
                "Active"
            }else {
                "InActive"
            }

           // Discription
            it.tvCompanyName.text = rocket?.company
            it.tvLauchCost.text = "$ ${rocket?.costPerLaunch}"
            it.tvStages.text = "${rocket?.stages} Stages"
            it.tvFirstLaunch.text = rocket?.firstFlight

            //specification
            it.tvHeight.text = "${rocket?.height?.meters} m - ${rocket?.height?.feet} ft"
            it.tvDiameter.text = "${rocket?.diameter?.meters} m - ${rocket?.diameter?.feet} ft"
            it.tvWeight.text = "${rocket?.mass?.kg} Kg -${rocket?.mass?.lb} Lb"
            it.tvFairingHeight.text = "${rocket?.secondStage?.payloads?.compositeFairing?.height?.meters} m"
            it.tvFairingDiameter.text = "${rocket?.secondStage?.payloads?.compositeFairing?.diameter?.meters} m"


            it.tvOrbit.text = "${rocket?.payloadWeights?.get(0)?.kg} Kg"


            it.tvFirstStageThrush.text = "${rocket?.firstStage?.thrustSeaLevel?.kN} KN"
            it.tvFuelAmount.text = "${rocket?.firstStage?.fuelAmountTons} Tons"
            it.tvEngines.text = "${rocket?.firstStage?.engines} Engine"
            it.tvReusable.text = if(rocket?.firstStage?.reusable == true){
                "Yes"
            }else {
                "No"
            }

            it.tvFirstStageThrush2.text = "${rocket?.secondStage?.thrust?.kN} KN"
            it.tvFuelAmount2.text = "${rocket?.secondStage?.fuelAmountTons} Tons"
            it.tvEngines2.text = "${rocket?.secondStage?.engines} Engine"
            it.tvReusable2.text = if(rocket?.secondStage?.reusable == true){
                "Yes"
            }else {
                "No"
            }

            it.tvModel.text = "${rocket?.engines?.type} ${rocket?.engines?.version}"
            it.tvThrustWeight.text = "${rocket?.engines?.thrustToWeight}"
            it.tvFuel.text = "${rocket?.engines?.propellant2}"
            it.tvOxidizer.text = "${rocket?.engines?.propellant1}"
            it.tvSeaLevelThrust.text = "${rocket?.engines?.thrustSeaLevel?.kN} KN"
            it.tvVacuumThrust.text = "${rocket?.engines?.thrustVacuum?.kN} KN"
            it.tvSeaLeveIsp.text = "${rocket?.engines?.isp?.seaLevel} s"
            it.tvVacuumIsp.text ="${rocket?.engines?.isp?.vacuum} s"

        }
    }

    override fun getViewBinding() = ActivitySpaceXrocketDetailBinding.inflate(layoutInflater)

}