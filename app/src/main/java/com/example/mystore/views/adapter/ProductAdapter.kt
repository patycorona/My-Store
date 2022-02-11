package com.example.mystore.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mystore.R
import com.example.mystore.models.Product

class ProductAdapter(
    private val dataSource: MutableList<Product>,
    var onListHitItemClickListener: ((product: Product) -> Unit),
    val context:Context
    ): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.tvName) as TextView
        var imgProduct:ImageView = view.findViewById(R.id.img_product) as ImageView
        var root: ConstraintLayout = view.findViewById(R.id.layout_item_product) as ConstraintLayout
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context )
            .inflate(R.layout.item_product , viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = dataSource[position].name
        //viewHolder.imgProduct.setImageDrawable(context.getDrawable(dataSource[position].productPhoto))

        Glide.with(context)
            //.load(context.getDrawable(dataSource[position].productPhoto))
            .load(dataSource[position].productPhoto)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(viewHolder.imgProduct)

        viewHolder.root.setOnClickListener {
            onListHitItemClickListener.invoke(dataSource[position])
        }
    }

    override fun getItemCount() = dataSource.size

}