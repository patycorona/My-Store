package com.example.mystore.models

import com.google.gson.annotations.SerializedName

data class ManyProductResponse (
    @SerializedName("product") val products: MutableList<ProductResponse> = mutableListOf()
)