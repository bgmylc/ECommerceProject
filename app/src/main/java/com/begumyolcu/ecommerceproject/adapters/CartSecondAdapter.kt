package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignCartBinding
import com.begumyolcu.ecommerceproject.databinding.CardDesignCartPriceBinding
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.mainappviewmodel.CartFragmentViewModel

class CartSecondAdapter (var mContext : Context, var cartList : List<Product>, var viewModel: CartFragmentViewModel) : RecyclerView.Adapter<CartSecondAdapter.CardDesignHolder>(){
    inner class CardDesignHolder(cardDesignCartPriceBinding: CardDesignCartPriceBinding) : RecyclerView.ViewHolder(cardDesignCartPriceBinding.root){
        var binding : CardDesignCartPriceBinding
        init {
            this.binding = cardDesignCartPriceBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignCartPriceBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        var subtotal : Double = 0.0
        for(i in cartList){
            subtotal = i.product_price.toDouble()
        }

        holder.binding.textViewCartSubtotal.text ="\$" + subtotal.toString()
        holder.binding.textViewCartTotal.text ="\$" + (subtotal+ 3.99).toString()
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}