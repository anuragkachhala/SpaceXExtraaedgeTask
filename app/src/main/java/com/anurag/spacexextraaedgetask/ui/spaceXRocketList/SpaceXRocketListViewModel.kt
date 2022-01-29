package com.anurag.spacexextraaedgetask.ui.spaceXRocketList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anurag.spacexextraaedgetask.model.Rocket
import com.anurag.spacexextraaedgetask.repository.SpaceXRocketRepository
import com.anurag.spacexextraaedgetask.utlis.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

@HiltViewModel
class SpaceXRocketListViewModel @Inject constructor(private val spaceXRocketRepository: SpaceXRocketRepository) : ViewModel() {

    private val _rocket: MutableLiveData<State<List<Rocket>>> = MutableLiveData(State.loading())

    val rockets: LiveData<State<List<Rocket>>> = _rocket

    fun getRockets() {
        viewModelScope.launch {
           val response =  spaceXRocketRepository.getRockets()
            if(response.isSuccessful && response.body()!=null){
               _rocket.postValue(State.success(response.body() as List<Rocket>))
            }else{
                _rocket.postValue(State.error("not avalilable"))
            }
        }
    }

}