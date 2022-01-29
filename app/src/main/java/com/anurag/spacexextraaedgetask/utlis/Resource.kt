package com.anurag.spacexextraaedgetask.utlis

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Failed<T>(val message: String) : Resource<T>()
}