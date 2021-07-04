package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignCampaignsBinding
import com.begumyolcu.ecommerceproject.databinding.CardDesignProductBinding
import com.begumyolcu.ecommerceproject.entity.Product
import com.begumyolcu.ecommerceproject.mainapp.CampaignFragmentDirections
import com.begumyolcu.ecommerceproject.mainapp.ProductFragmentDirections
import com.begumyolcu.ecommerceproject.mainappviewmodel.CampaignFragmentViewModel
import com.squareup.picasso.Picasso

class CampaignAdapter(var mContext: Context, var campaignList: List<Product>, var viewModel: CampaignFragmentViewModel) : RecyclerView.Adapter<CampaignAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(cardDesignCampaignsBinding: CardDesignCampaignsBinding) : RecyclerView.ViewHolder(cardDesignCampaignsBinding.root){
        var binding : CardDesignCampaignsBinding
        init {
            this.binding = cardDesignCampaignsBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignCampaignsBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val campaign = campaignList.get(position)
        holder.binding.product = campaign
        val image = holder.binding.imageViewCampaignCard
        Picasso.get().load(campaign.product_image_url).into(image)

        holder.binding.textViewCampaignCardOldPrice.text = (campaign.product_price.toDouble()*(100.0/65.0)).toString()
        holder.binding.campaignCardView.setOnClickListener {
            val campaignToDetail = CampaignFragmentDirections.campaignToDetailAction(campaign)
            Navigation.findNavController(it).navigate(campaignToDetail)
        }

    }

    override fun getItemCount(): Int {
        return campaignList.size
    }
}