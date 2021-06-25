package com.example.kisileruygulamasi.retrofit

import com.begumyolcu.ecommerceproject.entity.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserDaoInterface {
    @GET("giris_yap.php")
    fun loginToApp() : Call<UserResponse>

    @POST("uye_ol.php")
    @FormUrlEncoded
    fun registerToApp(@Field("kisi_ad") kisi_ad:String) : Call<UserResponse>


}