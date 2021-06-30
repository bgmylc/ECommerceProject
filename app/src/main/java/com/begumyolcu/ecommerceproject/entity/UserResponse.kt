package com.begumyolcu.ecommerceproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse(@SerializedName("kullanicilar")
                   @Expose
                   var users:List<User>,
                   @SerializedName("success")
                   @Expose
                   var success:Int) {
}