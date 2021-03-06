package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.CardDesignProfileFirstBinding
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProfileFragmentViewModel

class ProfileAdapter(var mContext : Context, var user_name: String, var user_mail : String, var user_phone : String, var viewModel: ProfileFragmentViewModel) : RecyclerView.Adapter<ProfileAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(profileFirstBinding: CardDesignProfileFirstBinding) : RecyclerView.ViewHolder(profileFirstBinding.root){
        var binding: CardDesignProfileFirstBinding
        init{
            this.binding = profileFirstBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignProfileFirstBinding.inflate(layoutInflater, parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        holder.binding.userName = user_name
        holder.binding.userMail = user_mail
        holder.binding.userPhone = user_phone

    }

    override fun getItemCount(): Int {
        return 1
    }
}
