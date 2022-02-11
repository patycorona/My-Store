package com.example.mystore.models

import android.graphics.drawable.Drawable

data class Product(
    var idProduct:Int,
    var name: String = "",
    var price: Double = 0.0,
    var discount: Int,
    var productPhoto: String,
    var stock: Int
) {
    fun add(product: Product) {

    }
}
