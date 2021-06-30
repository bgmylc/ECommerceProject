package com.begumyolcu.ecommerceproject.repo

import androidx.lifecycle.MutableLiveData
import com.begumyolcu.ecommerceproject.entity.CRUDResponse
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.entity.ProductResponse
import com.begumyolcu.ecommerceproject.retrofit.ApiUtils
import com.begumyolcu.ecommerceproject.retrofit.ProductsDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field

class ProductsDaoRepository {
    private val productsList: MutableLiveData<List<Product>>
    private val productsDaoInterface : ProductsDaoInterface

    init{
        productsDaoInterface = ApiUtils.getProductsDaoInterface()
        productsList = MutableLiveData()
    }

    fun bringProducts() : MutableLiveData<List<Product>> {
        return productsList
    }

    fun getProducts(seller_name : String) {
        productsDaoInterface.getProducts(seller_name).enqueue(object: Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>?, response: Response<ProductResponse>?) {
                val allProducts = response?.body()?.products
                val productListTemp = arrayListOf<Product>()
                for (i in allProducts!!){
                    if (i.seller_name == seller_name){
                        productListTemp.add(i)
                    }
                }
                productsList.value = productListTemp
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
}