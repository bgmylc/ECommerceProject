package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignCartBinding
import com.begumyolcu.ecommerceproject.databinding.CardDesignProductBinding
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.mainappviewmodel.CartFragmentViewModel
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProductFragmentViewModel
import com.squareup.picasso.Picasso

class CartAdapter (var mContext : Context, var cartList : List<Product>, var viewModel: CartFragmentViewModel) : RecyclerView.Adapter<CartAdapter.CardDesignHolder>(){
    inner class CardDesignHolder(cardDesignCartBinding: CardDesignCartBinding) : RecyclerView.ViewHolder(cardDesignCartBinding.root){
        var binding : CardDesignCartBinding
        init {
            this.binding = cardDesignCartBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignCartBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val product = cartList.get(position)
        holder.binding.product = product
        val image = holder.binding.imageViewCartCard
        Picasso.get().load(product.product_image_url).into(image)

        holder.binding.buttonCartCardDelete.setOnClickListener {
            viewModel.cartDelete(product.id)
        }
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}