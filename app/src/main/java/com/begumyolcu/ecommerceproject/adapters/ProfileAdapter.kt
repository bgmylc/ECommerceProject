package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignProfileFirstBinding
import com.begumyolcu.ecommerceproject.entity.User

class ProfileAdapter(var mContext : Context, var user : User) : RecyclerView.Adapter<ProfileAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(profileFirstBinding: CardDesignProfileFirstBinding) : RecyclerView.ViewHolder(profileFirstBinding.root){
        var design: CardDesignProfileFirstBinding
        init{
            this.design = profileFirstBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignProfileFirstBinding.inflate(layoutInflater, parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        holder.design.userObject = user
    }

    override fun getItemCount(): Int {
        return 1
    }
}
