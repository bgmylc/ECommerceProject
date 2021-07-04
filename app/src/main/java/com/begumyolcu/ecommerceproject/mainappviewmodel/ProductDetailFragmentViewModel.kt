package com.begumyolcu.ecommerceproject.mainappviewmodel

import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.repo.ProductsDaoRepository

class ProductDetailFragmentViewModel : ViewModel() {
    private val pdaor = ProductsDaoRepository()

    fun cartStatus(id : Int, cartStatus : Int){
        pdaor.cartStatusChange(id, cartStatus)
    }


}