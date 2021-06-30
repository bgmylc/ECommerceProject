package com.begumyolcu.ecommerceproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(@SerializedName("id")
                   @Expose
                   var id:Int,
                   @SerializedName("satici_adi")
                   @Expose
                   var seller_name:String,
                   @SerializedName("urun_adi")
                   @Expose
                   var product_name:String,
                   @SerializedName("urun_fiyat")
                   @Expose
                   var product_price:String,
                   @SerializedName("urun_aciklama")
                   @Expose
                   var product_description:String,
                   @SerializedName("urun_gorsel_url")
                   @Expose
                   var product_image_url:String,
                   @SerializedName("sepet_durum")
                   @Expose
                   var cart_status : Int,
                   @SerializedName("urun_indirimli_mi")
                   @Expose
                   var product_has_campaign : Int): Serializable {
}