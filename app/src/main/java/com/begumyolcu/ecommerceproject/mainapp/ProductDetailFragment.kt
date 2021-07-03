package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentEntrySwipeBinding
import com.begumyolcu.ecommerceproject.databinding.FragmentProductDetailBinding
import com.begumyolcu.ecommerceproject.entryviewmodel.EntryLoginFragmentViewModel
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProductDetailFragmentViewModel
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProfileFragmentViewModel


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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: ProductDetailFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cartFragmentAction -> {
                Navigation.findNavController(requireView()).navigate(R.id.productToCart)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

}