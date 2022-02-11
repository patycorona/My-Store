package com.example.mystore.mapping

import com.example.mystore.models.ManyProductResponse
import com.example.mystore.models.Product

internal fun ManyProductResponse.toModel(): MutableList<Product> {
    val productList: MutableList<Product> = mutableListOf()

    products.map { prod ->
        productList.add(
            Product(
                idProduct = prod.idProduct,
                name = prod.name,
                price = prod.price,
                discount = prod.discount,
                productPhoto = prod.productPhoto,
                stock = prod.stock
            )
        )
    }

    return productList

}
