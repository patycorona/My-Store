package com.example.mystore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mystore.models.ProductResult
import com.example.mystore.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    var productRepository: ProductRepository
    ): ViewModel() {

    // ayuda a liberar los recursos cuando utilizamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val listProducts : MutableLiveData<ProductResult> by lazy {
        MutableLiveData<ProductResult>()
    }

    fun getProduct(){
        compositeDisposable += productRepository.getProducts()
                .subscribeOn(Schedulers.io())
                .subscribe({listProduct ->
                    listProducts.postValue(
                       ProductResult(
                           sussess = true,
                           list = listProduct
                       )
                    )

                },{
                    listProducts.postValue(
                        ProductResult(
                            sussess = false
                        )
                    )

                })
        }

    override fun onCleared()
    {
        compositeDisposable.clear()
        super.onCleared()
    }

}