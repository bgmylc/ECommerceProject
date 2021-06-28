package com.begumyolcu.ecommerceproject.repo

import com.begumyolcu.ecommerceproject.entity.User

class UserDaoRepository {


    fun LoginUser() : User { //TODO: bunu düzelt
        val loggedUser = User(0,"a","a","a","a")
        return loggedUser
    }
}