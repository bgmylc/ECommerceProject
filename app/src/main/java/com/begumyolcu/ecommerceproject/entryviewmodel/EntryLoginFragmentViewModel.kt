package com.begumyolcu.ecommerceproject.entryviewmodel

import android.content.res.Resources
import android.util.Patterns
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.Event
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.repo.UserDaoRepository

class EntryLoginFragmentViewModel : ViewModel() {

    private val udaor = UserDaoRepository()
    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    fun validate(email: String, password: String) : Array<Unit> {

        val emailError = ObservableInt()
        val passwordError = ObservableInt()

        val isEmailValid = validateEmail(email)
        val isPasswordValid = validatePassword(password)

        if (isEmailValid == null && isPasswordValid == null){
            udaor.loginUser(email, password)
            val user = udaor.getUser()
            if (user != null){
                val text = Resources.getSystem().getString(R.string.loginSuccessMessage, user.value!!.name_surname)
                statusMessage.value = Event(text)
            }
            else{
                val text = Resources.getSystem().getString(R.string.loginErrorMessage)
                statusMessage.value = Event(text)
            }
            return arrayOf(emailError.set(0), passwordError.set(0)) //TODO: bunu ne yapsam?
        }
        else{
            return arrayOf(emailError.set(isEmailValid!!), passwordError.set(isPasswordValid!!))
        }

    }

    fun validateEmail(email: String): Int? {
        if (email.isEmpty()){
            return R.string.emailEmptyError
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches().not() ){
            return R.string.emailInvalidError
        }
        return null

    }

    private fun validatePassword(password : String): Int?{
        if (password.length < 8){
            return R.string.passwordInvalidError
        }
        if (password.isEmpty()){
            return R.string.passwordEmptyError
        }
        return null
    }
}