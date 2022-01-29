package com.anurag.spacexextraaedgetask.utlis

import android.app.Activity
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */



 /**
  * Returns Color from resource.
  * @param id Color Resource ID
  */
 fun Activity.getColorRes(@ColorRes id: Int) = ContextCompat.getColor(applicationContext, id)


