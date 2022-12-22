package com.example.aston_intensive_2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ProductListItemBinding


/**
 * Challenge 2.2
 * Адаптер, для списка, отображающего список покупок
 */
class ProductsListAdapter(
    private val context: Context,
    private val productsId: ArrayList<Int>,
) : RecyclerView.Adapter<ProductsListAdapter.ProductsListViewHolder>() {
    class ProductsListViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productTitle: String) {
            binding.productItemTitle.text = productTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsListViewHolder(
            ProductListItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder, position: Int) {
        val productList = context.resources.getStringArray(R.array.products)
        holder.bind(productList[productsId[position]])
    }

    override fun getItemCount() = productsId.size
}