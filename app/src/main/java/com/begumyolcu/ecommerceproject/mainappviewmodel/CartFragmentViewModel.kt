package com.begumyolcu.ecommerceproject.mainappviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.repo.ProductsDaoRepository

class CartFragmentViewModel : ViewModel() {
    private val pdaor = ProductsDaoRepository()
    var cartList = MutableLiveData<List<Product>>()

    init {
        pdaor.getCartProducts("begumyolcu")
        cartList = pdaor.bringCart()
    }

    fun cartDelete(id: Int, cartStat: Int = 0){
        pdaor.cartStatusChange(id, cartStat)
        pdaor.getCartProducts("begumyolcu")
        cartList = pdaor.bringCart()
    }

    fun cartTotal(cartList: List<Product>) : Double{
        var subtotal : Double = 0.0
        for(i in cartList){
            subtotal += i.product_price.toDouble()
        }

        return subtotal
    }
}