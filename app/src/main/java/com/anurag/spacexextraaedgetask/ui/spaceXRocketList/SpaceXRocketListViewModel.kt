package com.anurag.spacexextraaedgetask.ui.spaceXRocketList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anurag.spacexextraaedgetask.data.model.Rocket
import com.anurag.spacexextraaedgetask.repository.SpaceXRocketRepository
import com.anurag.spacexextraaedgetask.utlis.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

@HiltViewModel
class SpaceXRocketListViewModel @Inject constructor(private val spaceXRocketRepository: SpaceXRocketRepository
) : ViewModel() {

    private val _rocket: MutableStateFlow<State<List<Rocket>>> = MutableStateFlow(State.loading())

    val rockets: StateFlow<State<List<Rocket>>> = _rocket

    fun getRockets(){
        viewModelScope.launch {
            spaceXRocketRepository.getRockets()
                .map { resource -> State.fromResource(resource) }
                .collect { state -> _rocket.value = state }
        }
    }

}