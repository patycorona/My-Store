package com.example.mystore.api

import com.example.mystore.models.ManyProductResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoreHomeApi {

    @GET("/product")
    @Headers("Content-Type: application/json ")
    fun getProduct( ): Single<ManyProductResponse>
}