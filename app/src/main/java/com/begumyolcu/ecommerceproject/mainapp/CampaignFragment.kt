package com.begumyolcu.ecommerceproject.mainapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentCampaignBinding


class CampaignFragment : Fragment() {

    private lateinit var design : FragmentCampaignBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_campaign, container, false)
        return design.root
    }


}