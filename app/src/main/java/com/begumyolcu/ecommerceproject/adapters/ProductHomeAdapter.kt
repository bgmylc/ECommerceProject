package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignProductBinding
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.mainapp.ProductFragment
import com.begumyolcu.ecommerceproject.mainapp.ProductFragmentDirections
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProductFragmentViewModel
import com.squareup.picasso.Picasso

class ProductHomeAdapter(var mContext : Context, var productList : List<Product>, var viewModel: ProductFragmentViewModel) : RecyclerView.Adapter<ProductHomeAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(productCardBinding : CardDesignProductBinding) : RecyclerView.ViewHolder(productCardBinding.root){
        var binding : CardDesignProductBinding
        init {
            this.binding = productCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignProductBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val product = productList.get(position)
        val fragment = ProductFragment()

        val image = holder.binding.imageViewProductCard
        Picasso.get().load(product.product_image_url).into(image)

        holder.binding.productFragment = fragment
        holder.binding.product = product

        holder.binding.buttonProductCardAddCart.setOnClickListener {
            viewModel.cartStatus(product.id, product.cart_status)
        }
        holder.binding.ProductCardView.setOnClickListener {
            val actionToDetail = ProductFragmentDirections.productDetailAction(product)
            Navigation.findNavController(it).navigate(actionToDetail)
        }
        holder.binding.buttonProductCardInfo.setOnClickListener {
            val actionToDetail = ProductFragmentDirections.productDetailAction(product)
            Navigation.findNavController(it).navigate(actionToDetail)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}