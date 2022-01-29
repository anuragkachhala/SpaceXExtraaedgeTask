package com.anurag.spacexextraaedgetask.ui.spaceXRocketList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anurag.spacexextraaedgetask.repository.SpaceXRocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

@HiltViewModel
class SpaceXRocketListViewModel @Inject constructor(private val spaceXRocketRepository: SpaceXRocketRepository) : ViewModel() {

      init {
          getRockets()
      }

    fun getRockets() {
        viewModelScope.launch {
            spaceXRocketRepository.getRockets();
        }
    }

}