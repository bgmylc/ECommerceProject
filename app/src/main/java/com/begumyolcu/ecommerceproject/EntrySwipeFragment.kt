package com.begumyolcu.ecommerceproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.adapters.SwipeViewPagerAdapter
import com.begumyolcu.ecommerceproject.databinding.FragmentEntrySwipeBinding
import com.begumyolcu.ecommerceproject.entity.SwipeItem


class EntrySwipeFragment : Fragment() {

    private lateinit var design:FragmentEntrySwipeBinding
    private lateinit var swipeItems:List<SwipeItem>
    private lateinit var adapter: SwipeViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_entry_swipe, container, false)

        val si1 = SwipeItem(getString(R.string.swipeItemText1), 1, "swipe_image_one")
        val si2 = SwipeItem(getString(R.string.swipeItemText2), 2, "swipe_image_two")
        val si3 = SwipeItem(getString(R.string.swipeItemText3), 3, "swipe_image_three")

        swipeItems = listOf(si1,si2,si3)
        adapter = SwipeViewPagerAdapter(requireContext(), swipeItems)
        design.viewPagerAdapter = adapter

        return design.root
    }

}