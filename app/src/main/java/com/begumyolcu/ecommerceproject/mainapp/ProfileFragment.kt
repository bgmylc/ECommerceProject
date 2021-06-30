package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentProfileBinding
import com.begumyolcu.ecommerceproject.entity.ProfileItem
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProfileFragmentViewModel


class ProfileFragment : Fragment() {
    private lateinit var design : FragmentProfileBinding
    private lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var actionList: ArrayList<ProfileItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)


        actionList = ArrayList()
        val i1 = ProfileItem(1, getString(R.string.adresses), "icon_location")
        val i2 = ProfileItem(2, getString(R.string.favouriteSellers), "icon_fav")
        val i3 = ProfileItem(3, getString(R.string.paymentMethods), "icon_payment")
        actionList.add(i1);actionList.add(i2);actionList.add(i3)


        return design.root
    }


}