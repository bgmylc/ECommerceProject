package com.begumyolcu.ecommerceproject.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.begumyolcu.ecommerceproject.entity.CRUDResponse
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.entity.ProductResponse
import com.begumyolcu.ecommerceproject.retrofit.ApiUtils
import com.begumyolcu.ecommerceproject.retrofit.ProductsDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsDaoRepository {
    private val productsList: MutableLiveData<List<Product>>
    private val productsDaoInterface : ProductsDaoInterface
    private val campaignList : MutableLiveData<List<Product>>
    private val cartList : MutableLiveData<List<Product>>

    init{
        productsDaoInterface = ApiUtils.getProductsDaoInterface()
        productsList = MutableLiveData()
        campaignList = MutableLiveData()
        cartList = MutableLiveData()
    }

    fun bringProducts() : MutableLiveData<List<Product>> {
        return productsList
    }

    fun getProducts(seller_name : String) {
        productsDaoInterface.getProducts(seller_name).enqueue(object: Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>?, response: Response<ProductResponse>) {
                val allProducts = response.body().products
                productsList.value = allProducts
            }
            override fun onFailure(call: Call<ProductResponse>?, t: Throwable?) {}
        })
    }

    fun cartStatusChange(id:Int, cart_status:Int){
        productsDaoInterface.changeCartStatus(id, cart_status).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {}
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}

        })
    }

    fun addProducts(seller_name:String, product_name:String, product_price : String, product_description:String, product_image_url:String){
        productsDaoInterface.addProduct(seller_name, product_name, product_price, product_description, product_image_url).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {}
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}

        })
    }

    fun changeCampaignStatus(id:Int, product_has_campaign : Int){
        productsDaoInterface.changeCampaignStatus(id, product_has_campaign).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {}
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}

        })
    }

    fun getCampaignProducts(seller_name: String){
        productsDaoInterface.getProducts(seller_name).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>?, response: Response<ProductResponse>) {
                val products = response.body().products
                val temp = arrayListOf<Product>()
                for(i in products){
                    if (i.product_has_campaign == 1) {
                        temp.add(i)
                    }
                }
                campaignList.value = temp
            }
            override fun onFailure(call: Call<ProductResponse>?, t: Throwable?) {}
        })
    }

    fun bringCampaign() : MutableLiveData<List<Product>>  {
        return campaignList
    }

    fun getCartProducts(seller_name: String){
        productsDaoInterface.getProducts(seller_name).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>?, response: Response<ProductResponse>) {
                val products = response.body().products
                val temp = arrayListOf<Product>()
                for(i in products){
                    if (i.cart_status == 1) {
                        temp.add(i)
                    }
                }
                cartList.value = temp
            }
            override fun onFailure(call: Call<ProductResponse>?, t: Throwable?) {}
        })
    }

    fun bringCart() : MutableLiveData<List<Product>>  {
        return cartList
    }
}