package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.adapters.ProductHomeAdapter
import com.begumyolcu.ecommerceproject.databinding.FragmentProductBinding
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProductFragmentViewModel


class ProductFragment : Fragment() {

    private lateinit var design : FragmentProductBinding
    private lateinit var viewModel: ProductFragmentViewModel
    private lateinit var adapter : ProductHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design =  DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)

        viewModel.productsList.observe(viewLifecycleOwner, { productsList ->
            adapter = ProductHomeAdapter(requireContext(), productsList, viewModel)
            design.adapter = adapter
        })

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: ProductFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cartFragmentAction -> {
                Navigation.findNavController(requireView()).navigate(R.id.homeToCart)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    fun onInfoPressed(product: Product){
        val actionToDetail = ProductFragmentDirections.productDetailAction(product)
        Navigation.findNavController(requireView()).navigate(actionToDetail)
    }


}