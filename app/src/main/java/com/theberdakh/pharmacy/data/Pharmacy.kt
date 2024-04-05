package com.theberdakh.pharmacy.data

import androidx.annotation.DrawableRes
import com.theberdakh.pharmacy.R

data class Pharmacy(
    val id: Int,
    val name: String,
    @DrawableRes val pic: Int,
    val subtitle: String
)
