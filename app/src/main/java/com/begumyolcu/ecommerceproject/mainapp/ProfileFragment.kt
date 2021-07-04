package com.begumyolcu.ecommerceproject.mainapp

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.adapters.ProfileAdapter
import com.begumyolcu.ecommerceproject.adapters.ProfileItemAdapter
import com.begumyolcu.ecommerceproject.databinding.FragmentProfileBinding
import com.begumyolcu.ecommerceproject.entity.ProfileItem
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProfileFragmentViewModel
import com.google.gson.Gson


class ProfileFragment : Fragment() {
    private lateinit var design : FragmentProfileBinding
    private lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var adapterOne : ProfileAdapter
    private lateinit var adapterTwo : ProfileItemAdapter
    private lateinit var actionList: ArrayList<ProfileItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        (activity as AppCompatActivity).setSupportActionBar(design.toolbarProfile)
        design.toolbarTitleEmpty = ""

        val userPreference: UserPreference? = UserPreference.getInstance(requireContext())

        val user_name: String = userPreference?.getData("user_name").toString()
        val user_mail: String = userPreference?.getData("user_email").toString()
        val user_phone: String = userPreference?.getData("user_phone").toString()

        adapterOne = ProfileAdapter(requireContext(), user_name, user_mail, user_phone, viewModel)

        design.rvOneAdapter = adapterOne

        actionList = ArrayList()
        val i1 = ProfileItem(1, getString(R.string.adresses), "icon_location")
        val i2 = ProfileItem(2, getString(R.string.favouriteSellers), "icon_fav")
        val i3 = ProfileItem(3, getString(R.string.paymentMethods), "icon_payment")

        actionList.add(i1);actionList.add(i2);actionList.add(i3)
        adapterTwo = ProfileItemAdapter(requireContext(), actionList)

        design.rvTwoAdapter = adapterTwo

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: ProfileFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cartFragmentAction -> {
                Navigation.findNavController(requireView()).navigate(R.id.profileToCart)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

}