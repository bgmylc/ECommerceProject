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
}