package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.adapters.CartAdapter
import com.begumyolcu.ecommerceproject.databinding.FragmentCartBinding
import com.begumyolcu.ecommerceproject.mainappviewmodel.CartFragmentViewModel
import kotlin.math.round

class CartFragment : Fragment() {
    private lateinit var design: FragmentCartBinding
    private lateinit var viewModel: CartFragmentViewModel
    private lateinit var adapterOne : CartAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        viewModel = CartFragmentViewModel()

        viewModel.cartList.observe(viewLifecycleOwner,{ cartList ->
            adapterOne = CartAdapter(requireContext(), cartList, viewModel)
            val subtotal = viewModel.cartTotal(cartList)
            design.subtotal = round(subtotal)
            design.total= round(subtotal+ 3.99)
            design.adapterOne = adapterOne
        })
        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: CartFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

}