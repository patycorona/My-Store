package com.example.mystore.repository

import com.example.mystore.R
import com.example.mystore.models.Product
import io.reactivex.Single

import javax.inject.Inject

class ProductRepository @Inject constructor(
){
    fun getProduct(): Single<ArrayList<Product>>
    {
        var listProduct: ArrayList<Product> = arrayListOf()
        listProduct.add(Product(idProduct = 0,name= "Juice", prece = 12.00, discount = 0, productPhoto = R.drawable.juice, stock = 15))
        listProduct.add(Product(idProduct = 1,name= "Shoes", prece = 800.00, discount = 10, productPhoto = R.drawable.shoes, stock = 5))
        listProduct.add(Product(idProduct = 2,name= "Cristmas Sweater", prece = 449.90, discount = 0, productPhoto = R.drawable.sweater, stock = 15))
        listProduct.add(Product(idProduct = 3,name= "Air Pods", prece = 449.90, discount = 0, productPhoto = R.drawable.airpods, stock = 25))
        listProduct.add(Product(idProduct = 4,name= "Gafas para sol", prece = 122.50, discount = 10, productPhoto = R.drawable.gafas, stock = 18))
        listProduct.add(Product(idProduct = 5,name= "Cartera pequeña", prece = 659.90, discount = 15, productPhoto = R.drawable.cartera, stock = 15))

        return Single.just(listProduct)
    }
}