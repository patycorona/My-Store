package com.example.mystore.models

import com.google.gson.annotations.SerializedName

data class ApiNewsHitsModel (
    @SerializedName("hits") val hits: MutableList<ApiHitModel> = mutableListOf(),
    @SerializedName("page") val page: Int = 0,
    @SerializedName("totalPages") val totalPages: Int = 0,
    @SerializedName("hitsPerPage") val hitsPerPage: Int = 0
)
