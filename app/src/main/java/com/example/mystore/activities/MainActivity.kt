package com.example.mystore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystore.databinding.ActivityMainBinding
import com.example.mystore.models.Product
import com.example.mystore.models.ProductResult
import com.example.mystore.viewmodel.ProductViewModel
import com.example.mystore.views.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    var binding: ActivityMainBinding? = null

    private  val viewModelProduct: ProductViewModel by viewModels()

    private val listProductObserver = Observer<ProductResult>{ productResult ->
        if(productResult.sussess){
            productResult.list?.let {
                val adapter = ProductAdapter(
                    it,
                    onItemClickListener,
                    applicationContext
                )
                binding?.recyclerview?.adapter = adapter
                adapter.notifyDataSetChanged()

            }
        }
    }

    // Callback
    private  var onItemClickListener: ((product:Product)-> Unit) = { product ->
        Toast.makeText(this, "Product: " + product.name + "  "+ "Price: $" + product.prece, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initRecycler()
        initObserver()
        viewModelProduct.getProduct()
    }
     private  fun initObserver(){
       viewModelProduct.listProducts.observe(this,listProductObserver)
     }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding?.recyclerview?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
           // itemAnimator = DefaultItemAnimator()
        }
    }

}