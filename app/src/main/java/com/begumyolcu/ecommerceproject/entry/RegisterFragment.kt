package com.begumyolcu.ecommerceproject.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentRegisterBinding
import com.begumyolcu.ecommerceproject.entryviewmodel.EntryLoginFragmentViewModel
import com.begumyolcu.ecommerceproject.entryviewmodel.RegisterFragmentViewModel


class RegisterFragment : Fragment() {

    private lateinit var design: FragmentRegisterBinding
    private lateinit var viewModel: RegisterFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        return design.root
    }

}