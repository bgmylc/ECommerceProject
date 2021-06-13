package com.begumyolcu.ecommerceproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.ecommerceproject.databinding.FragmentEntryLoginBinding
import com.begumyolcu.ecommerceproject.databinding.FragmentEntrySwipeBinding


class EntryLoginFragment : Fragment() {

    private lateinit var design: FragmentEntryLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_entry_login, container, false)

        return design.root
    }
}