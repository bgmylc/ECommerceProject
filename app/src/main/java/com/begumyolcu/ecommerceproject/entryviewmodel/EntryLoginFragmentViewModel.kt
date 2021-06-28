package com.begumyolcu.ecommerceproject.entryviewmodel

import android.util.Patterns
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.repo.UserDaoRepository
import kotlinx.coroutines.withContext

class EntryLoginFragmentViewModel : ViewModel() {

    private val udaor = UserDaoRepository()

    fun validate(email: String, password: String) : Array<Unit> {

        val emailError = ObservableInt()
        val passwordError = ObservableInt()

        val isEmailValid = validateEmail(email)
        val isPasswordValid = validatePassword(password)

        if (isEmailValid == null && isPasswordValid == null){
            udaor.LoginUser()
            return arrayOf(emailError.set(0), passwordError.set(0)) //TODO: Burayı da loginCheck'e göre düzelt
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