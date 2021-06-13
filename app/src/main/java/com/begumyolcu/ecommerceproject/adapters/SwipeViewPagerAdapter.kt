package com.begumyolcu.ecommerceproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.ecommerceproject.databinding.ItemSwipeViewpagerBinding
import com.begumyolcu.ecommerceproject.entity.SwipeItem

class SwipeViewPagerAdapter (var mContext: Context, var swipeItems : List<SwipeItem>) : RecyclerView.Adapter<SwipeViewPagerAdapter.SwipeViewPagerViewHolder>(){

    inner class SwipeViewPagerViewHolder(itemSwipeViewpagerBinding: ItemSwipeViewpagerBinding)
        : RecyclerView.ViewHolder(itemSwipeViewpagerBinding.root){

        var itemSwipe: ItemSwipeViewpagerBinding

        init {
            this.itemSwipe = itemSwipeViewpagerBinding
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeViewPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val design = ItemSwipeViewpagerBinding.inflate(layoutInflater, parent, false)
        return SwipeViewPagerViewHolder(design)
    }

    override fun onBindViewHolder(holder: SwipeViewPagerViewHolder, position: Int) {
        val swipeItem = swipeItems.get(position)
        holder.itemSwipe.itemS = swipeItem
        holder.itemSwipe.entrySwipeImageView.setImageResource(mContext.resources.getIdentifier(swipeItem.swipeImage, "drawable", mContext.packageName))

    }

    override fun getItemCount(): Int {
        return swipeItems.size

    }
}