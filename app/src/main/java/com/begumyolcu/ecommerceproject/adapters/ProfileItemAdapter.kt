package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignProfileSecondBinding
import com.begumyolcu.ecommerceproject.entity.ProfileItem

class ProfileItemAdapter (var mContext : Context, var profileItemList : ArrayList<ProfileItem>) : RecyclerView.Adapter<ProfileItemAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(cardDesignProfileSecondBinding: CardDesignProfileSecondBinding) : RecyclerView.ViewHolder(cardDesignProfileSecondBinding.root){
        var binding: CardDesignProfileSecondBinding

        init{
            this.binding = cardDesignProfileSecondBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignProfileSecondBinding.inflate(layoutInflater, parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val profileItem = profileItemList.get(position)

        holder.binding.textViewUserActionName.text = profileItem.item_name
        holder.binding.imageViewUserAction.setImageResource(mContext.resources.getIdentifier(profileItem.profile_item_logo, "drawable", mContext.packageName))
    }

    override fun getItemCount(): Int {
        return profileItemList.size
    }

}