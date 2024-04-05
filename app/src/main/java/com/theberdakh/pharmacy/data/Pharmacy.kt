package com.theberdakh.pharmacy.data

import androidx.annotation.DrawableRes
import com.theberdakh.pharmacy.R

data class Pharmacy(
    val id: Int,
    val name: String,
    @DrawableRes val pic: Int,
    val subtitle: String
)

fun getAllPharmacies() = listOf(
    Pharmacy(
        id = 1,
        name = "Ajinyaz Qaraqalpaq",
        pic = R.drawable.ajinyaz_com,
        subtitle = "200 metr aralıqta"
    ),
    Pharmacy(
        id = 2,
        name = "MIR",
        pic = R.drawable.mir_com,
        subtitle = "500 metr aralıqta"
    ),
    Pharmacy(
        id = 3,
        name = "Rano apteka",
        pic = R.drawable.rano_com,
        subtitle = "500 metr aralıqta"
    ),
)
