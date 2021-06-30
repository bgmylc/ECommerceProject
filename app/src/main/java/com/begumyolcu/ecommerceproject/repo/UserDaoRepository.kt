package com.begumyolcu.ecommerceproject.repo

import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.entity.CRUDResponse
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.entity.UserResponse
import com.begumyolcu.ecommerceproject.retrofit.ApiUtils
import com.example.kisileruygulamasi.retrofit.UsersDaoInterface
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDaoRepository {
    private val user: MutableLiveData<User>
    private val userDaoInterface : UsersDaoInterface

    init{
        userDaoInterface = ApiUtils.getUsersDaoInterface()
        user = MutableLiveData()
    }

    fun getUser() : MutableLiveData<User>{
        return user
    }

    fun loginUser(mail_address: String, password: String) {
        userDaoInterface.loginToApp(mail_address, password).enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                val list = response?.body()?.users
                for(i in list!!){
                    val user_test = i
                    if (user_test.login_value == 1){
                        user.value = user_test

                    }
                    else user.value = null
                }

            }
            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {}

        })
    }

    fun registerUser(mail_address: String, password: String, name_surname: String, phone : String){
        userDaoInterface.registerToApp(mail_address, password, name_surname, phone).enqueue(object: Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>?, response: Response<CRUDResponse?>?) {}
            override fun onFailure(call: Call<CRUDResponse?>?, t: Throwable?) {}
        })
    }
}