package com.example.mystore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystore.R
import com.example.mystore.databinding.ActivityMainBinding
import com.example.mystore.models.Product
import com.example.mystore.views.adapter.ProductAdapter

class MainActivity : AppCompatActivity(){

    var binding: ActivityMainBinding? = null
    var listProduct: ArrayList<Product> = arrayListOf()

    // Callback
    private  var onItemClickListener: ((product:Product)-> Unit) = { product ->
        Toast.makeText(this, "Product: " + product.name + "  "+ "Price: $" + product.prece, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initRecycler()
        createData()
        setAdapter()

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

    private fun createData() {
        listProduct.add(Product(idProduct = 0,name= "Juice", prece = 12.00, discount = 0, productPhoto = R.drawable.juice, stock = 15))
        listProduct.add(Product(idProduct = 1,name= "Shoes", prece = 800.00, discount = 10, productPhoto = R.drawable.shoes, stock = 5))
        listProduct.add(Product(idProduct = 2,name= "Cristmas Sweater", prece = 449.90, discount = 0, productPhoto = R.drawable.sweater, stock = 15))
        listProduct.add(Product(idProduct = 3,name= "Air Pods", prece = 449.90, discount = 0, productPhoto = R.drawable.airpods, stock = 25))
        listProduct.add(Product(idProduct = 4,name= "Gafas para sol", prece = 122.50, discount = 10, productPhoto = R.drawable.gafas, stock = 18))
        listProduct.add(Product(idProduct = 5,name= "Cartera pequeña", prece = 659.90, discount = 15, productPhoto = R.drawable.cartera, stock = 15))

    }

    private fun setAdapter() {
        val adapter = ProductAdapter(
            listProduct,
            onItemClickListener,
            this
        )
        binding?.recyclerview?.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}