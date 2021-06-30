package com.begumyolcu.ecommerceproject.entity

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(@SerializedName("id")
                @Expose
                var id:Int,
                @SerializedName("mail_adres")
                @Expose
                var mail_address:String,
                @SerializedName("sifre")
                @Expose
                var password:String,
                @SerializedName("ad_soyad")
                @Expose
                var name_surname:String,
                @SerializedName("telefon")
                @Expose
                var phone:String,
                @SerializedName("deger")
                @Expose
                var login_value:Int): Serializable {
}