package com.theberdakh.pharmacy.data

data class Medicine(
    val characteristics: String,
    val composition: String,
    val conditions: String,
    val definition: String,
    val disclaimer: String,
    val id: Int,
    val main_element: String,
    val name: String,
    val pharmacokinetics: String,
    val side_effects: String,
    val special_instruction: String,
    val term: String,
    val type: Int,
    val usage: String
)