package com.example.kisileruygulamasi.retrofit

import com.begumyolcu.ecommerceproject.entity.CRUDResponse
import com.begumyolcu.ecommerceproject.entity.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface UsersDaoInterface {
    @POST("giris_yap.php")
    fun loginToApp(@Field("mail_adres") mail_address: String, @Field("sifre") password: String ) : Call<UserResponse>

    @POST("uye_ol.php")
    @FormUrlEncoded
    fun registerToApp(@Field("mail_adres") mail_address: String, @Field("sifre") password: String, @Field("ad_soyad") name_surname: String, @Field("telefon") phone: String) : Call<CRUDResponse>



}