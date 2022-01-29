package com.anurag.spacexextraaedgetask.ui.spaceXRocketDetails

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
class SpaceXRocketDetailViewModel @Inject constructor(private val spaceXRocketRepository: SpaceXRocketRepository) : ViewModel() {

    private val _rocket: MutableLiveData<State<Rocket>> = MutableLiveData(State.loading())

    val rocket: LiveData<State<Rocket>> = _rocket

   /* init {
        getRocket()
    }
*/
    fun getRocket(id : String) {
        viewModelScope.launch {
           // val response =  spaceXRocketRepository.getRocketById("5e9d0d95eda69955f709d1eb")
            val response =  spaceXRocketRepository.getRocketById(id)
            if(response.isSuccessful && response.body()!=null){
                _rocket.postValue(State.success(response.body() as Rocket))
            }else{
                _rocket.postValue(State.error("not avalilable"))
            }
        }
    }

}