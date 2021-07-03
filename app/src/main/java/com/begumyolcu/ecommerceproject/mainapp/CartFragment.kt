package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentCartBinding
import com.begumyolcu.ecommerceproject.mainappviewmodel.CartFragmentViewModel

//TODO: Sepete eklenince eklendi diye Toast çıkar
class CartFragment : Fragment() {
    private lateinit var design: FragmentCartBinding
    private lateinit var viewModel: CartFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return design.root
    }

}