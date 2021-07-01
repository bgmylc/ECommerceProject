package com.begumyolcu.ecommerceproject.retrofit

import com.begumyolcu.ecommerceproject.entity.CRUDResponse
import com.begumyolcu.ecommerceproject.entity.ProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ProductsDaoInterface {
    @POST("indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun changeCampaignStatus(@Field("id") id:Int, @Field("urun_indirimli_mi") product_has_campaign : Int) : Call<CRUDResponse>

    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun changeCartStatus(@Field("id") id:Int, @Field("sepet_durum") cart_status : Int) : Call<CRUDResponse>

    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun addProduct(@Field("satici_adi") seller_name:String,
                   @Field("urun_adi") product_name:String,
                   @Field("urun_fiyat") product_price : String,
                   @Field("urun_aciklama") product_description:String,
                   @Field("urun_gorsel_url")product_image_url:String ) : Call<CRUDResponse>

    @POST("urunler.php")
    @FormUrlEncoded
    fun getProducts(@Field("satici_adi") seller_name:String) : Call<ProductResponse>
}