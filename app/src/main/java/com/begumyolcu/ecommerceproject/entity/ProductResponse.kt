package com.begumyolcu.ecommerceproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductResponse (@SerializedName("urunler")
                       @Expose
                       var products:List<Product>,
                       @SerializedName("success")
                       @Expose
                       var success:Int) {
}