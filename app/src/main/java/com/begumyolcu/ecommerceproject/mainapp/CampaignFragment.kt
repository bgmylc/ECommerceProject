package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.adapters.CampaignAdapter
import com.begumyolcu.ecommerceproject.databinding.FragmentCampaignBinding
import com.begumyolcu.ecommerceproject.entryviewmodel.EntryLoginFragmentViewModel
import com.begumyolcu.ecommerceproject.mainappviewmodel.CampaignFragmentViewModel
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProfileFragmentViewModel


class CampaignFragment : Fragment() {
    private lateinit var design : FragmentCampaignBinding
    private lateinit var viewModel: CampaignFragmentViewModel
    private lateinit var adapter : CampaignAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_campaign, container, false)

        (activity as AppCompatActivity).setSupportActionBar(design.toolbarCampaign)
        design.emptyTitle =""

        viewModel.campaignList.observe(viewLifecycleOwner, { campaigns ->
            adapter = CampaignAdapter(requireContext(), campaigns, viewModel)
            design.adapter = adapter
        })


        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: CampaignFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cartFragmentAction -> {
                Navigation.findNavController(requireView()).navigate(R.id.campaignToCart)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }


}