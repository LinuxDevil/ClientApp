package com.aligmohammad.doctorapp.data.model

import androidx.navigation.NavDirections

data class RecyclerMenuItem (
    val name: String,
    val imageUrl: String,
    val direction: NavDirections
)