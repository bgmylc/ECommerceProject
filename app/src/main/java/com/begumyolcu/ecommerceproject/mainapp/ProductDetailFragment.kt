package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentEntrySwipeBinding
import com.begumyolcu.ecommerceproject.databinding.FragmentProductDetailBinding
import com.begumyolcu.ecommerceproject.entryviewmodel.EntryLoginFragmentViewModel
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProductDetailFragmentViewModel


class ProductDetailFragment : Fragment() {
    private lateinit var design: FragmentProductDetailBinding
    private lateinit var viewModel: ProductDetailFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)
        return design.root
    }

}