package com.begumyolcu.ecommerceproject.mainappviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.entity.User

class ProfileFragmentViewModel : ViewModel() {

    private val mutableloggedUser = MutableLiveData<User>()
    val loggedInUser: LiveData<User>  get() = mutableloggedUser

    fun getUser(user: User) {
        mutableloggedUser.value = user
    }
}