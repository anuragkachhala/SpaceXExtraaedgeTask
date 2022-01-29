package com.anurag.spacexextraaedgetask.ui.base

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.anurag.spacexextraaedgetask.R
import com.anurag.spacexextraaedgetask.utlis.NetworkUtils

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

/**
 * Abstract Activity which binds [ViewModel] [VM] and [ViewBinding] [VB]
 */
abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected abstract val viewModel: VM

    private var _binding: VB? = null
    protected val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
    }

    protected abstract fun getViewBinding(): VB


}