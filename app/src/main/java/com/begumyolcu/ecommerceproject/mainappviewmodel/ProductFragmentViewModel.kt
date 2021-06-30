package com.begumyolcu.ecommerceproject.mainappviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.retrofit.ProductsDaoInterface

class ProductFragmentViewModel : ViewModel() {
    var productsList = MutableLiveData<List<Product>>()

}