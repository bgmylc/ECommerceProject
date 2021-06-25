package com.begumyolcu.ecommerceproject.retrofit

import com.example.kisileruygulamasi.retrofit.UserDaoInterface

class ApiUtils {

    companion object{

        val BASE_URL = "http://upschool.canerture.com/"

        fun getKisilerDaoInterface(): UserDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(UserDaoInterface::class.java)
        }
    }
}



