package com.begumyolcu.ecommerceproject.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentEntryLoginBinding


class EntryLoginFragment : Fragment() {

    private lateinit var design: FragmentEntryLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_entry_login, container, false)
        design.entryLoginFragment = this
        return design.root
    }

    fun registerPressed(v: View){
        Navigation.findNavController(v).navigate(R.id.loginToRegisterAction)
    }
}