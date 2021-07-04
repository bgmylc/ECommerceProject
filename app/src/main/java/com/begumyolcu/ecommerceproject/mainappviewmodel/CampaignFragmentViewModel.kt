package com.begumyolcu.ecommerceproject.mainappviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.repo.ProductsDaoRepository

class CampaignFragmentViewModel : ViewModel() {
    private val pdaor = ProductsDaoRepository()
    var campaignList = MutableLiveData<List<Product>>()


    init{
        pdaor.getCampaignProducts("begumyolcu")
        campaignList = pdaor.bringCampaign()
    }


}