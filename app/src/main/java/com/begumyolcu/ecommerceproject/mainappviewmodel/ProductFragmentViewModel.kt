package com.begumyolcu.ecommerceproject.mainappviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.repo.ProductsDaoRepository

class ProductFragmentViewModel : ViewModel() {
    private val pdaor = ProductsDaoRepository()
    var productsList = MutableLiveData<List<Product>>()

    init{
        getProducts("begumyolcu")
        productsList = pdaor.bringProducts()

    }
    fun addNewProduct(seller_name:String, product_name:String, product_price : String, product_description:String, product_image_url:String){
        pdaor.addProducts(seller_name, product_name, product_price, product_description, product_image_url)
    }

    fun getProducts(seller_name : String){
        pdaor.getProducts(seller_name)
    }

    fun cartStatus(id : Int, cartStatus : Int){
        pdaor.cartStatusChange(id, cartStatus)
    }

    fun campaign(id: Int, campaignStat : Int){
        pdaor.changeCampaignStatus(id, campaignStat)
    }


}