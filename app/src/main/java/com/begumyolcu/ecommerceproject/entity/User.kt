package com.begumyolcu.ecommerceproject.entity

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(@SerializedName("id")
                @Expose
                var id:Int,
                @SerializedName("mail_adres")
                @Expose
                var mail_adres:String,
                @SerializedName("sifre")
                @Expose
                var sifre:String,
                @SerializedName("ad_soyad")
                @Expose
                var ad_soyad:String,
                @SerializedName("telefon")
                @Expose
                var telefon:String): Serializable {
}