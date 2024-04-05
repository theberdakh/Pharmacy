package com.theberdakh.pharmacy.data

import android.content.Context
import com.google.gson.GsonBuilder


fun Context.jsonToString(name: String) = this.assets.open(name).bufferedReader().use { it.readText() }

fun convertJsonString(jsonString: String): Array<Medicine>? {
    val gsonBuilder = GsonBuilder()
    val gson = gsonBuilder.create()

    return gson.fromJson(jsonString, Array<Medicine>::class.java)
}