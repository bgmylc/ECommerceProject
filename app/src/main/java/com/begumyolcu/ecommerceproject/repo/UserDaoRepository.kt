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
    var userList: MutableLiveData<List<User>>
    private val userDaoInterface : UsersDaoInterface

    init{
        userDaoInterface = ApiUtils.getUsersDaoInterface()
        userList = MutableLiveData()
    }

    fun loginUser(mail_address: String, password: String) {
        userDaoInterface.loginToApp(mail_address, password).enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>) {
                userList.value = response.body().users
            }
            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }

        })
    }

    fun registerUser(mail_address: String, password: String, name_surname: String, phone : String){
        userDaoInterface.registerToApp(mail_address, password, name_surname, phone).enqueue(object: Callback<CRUDResponse?> {
            override fun onResponse(call: Call<CRUDResponse?>?, response: Response<CRUDResponse?>?) {}
            override fun onFailure(call: Call<CRUDResponse?>?, t: Throwable?) {}
        })
    }
}