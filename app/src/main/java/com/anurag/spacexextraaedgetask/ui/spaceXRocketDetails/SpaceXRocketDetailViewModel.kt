package com.anurag.spacexextraaedgetask.ui.spaceXRocketDetails

import androidx.lifecycle.*
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.repository.SpaceXRocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

@HiltViewModel
class SpaceXRocketDetailViewModel @Inject constructor(private val spaceXRocketRepository: SpaceXRocketRepository) : ViewModel() {


    private val _id = MutableLiveData<String>()

    private val _rocket = _id.switchMap { id ->
        spaceXRocketRepository.getRocketDetailsById(id).asLiveData()
    }
    val rocket: LiveData<Rocket> = _rocket

    fun start(id: String) {
        _id.value = id
    }



}