package com.begumyolcu.ecommerceproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse(@SerializedName("kullanicilar")
                   @Expose
                   var kullanici:User,
                   @SerializedName("success")
                   @Expose
                   var success:Int) {
}