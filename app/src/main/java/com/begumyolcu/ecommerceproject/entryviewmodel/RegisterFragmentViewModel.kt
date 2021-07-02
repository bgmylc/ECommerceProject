package com.begumyolcu.ecommerceproject.entryviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.repo.UserDaoRepository

class RegisterFragmentViewModel : ViewModel() {
    private val udaor = UserDaoRepository()
    var loggedUser: MutableLiveData<User> = MutableLiveData()

    fun register(mail_address: String, password: String, name_surname: String, phone : String){
        udaor.registerUser(mail_address, password, name_surname, phone)
    }
}