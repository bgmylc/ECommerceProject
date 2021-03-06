package com.begumyolcu.ecommerceproject.entry

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.databinding.FragmentEntryLoginBinding
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.entryviewmodel.EntryLoginFragmentViewModel
import com.begumyolcu.ecommerceproject.mainapp.MainActivity


class EntryLoginFragment : Fragment() {

    private lateinit var design: FragmentEntryLoginBinding
    private lateinit var viewModel: EntryLoginFragmentViewModel
    lateinit var logUser : User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_entry_login, container, false)
        design.entryLoginFragment = this
        design.lifecycleOwner = this

        viewModel.userList.observe(viewLifecycleOwner, { userList ->
           if (userList[0].login_value == 1){
               Toast.makeText(requireContext(), getString(R.string.loginSuccessMessage, userList[0].name_surname), Toast.LENGTH_LONG).show()
               val newIntent = Intent(activity, MainActivity::class.java)
               newIntent.putExtra("user", userList[0])
               startActivity(newIntent)
           }else{
               Toast.makeText(requireContext(), getString(R.string.loginErrorMessage), Toast.LENGTH_LONG).show()
           }
        })
        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel: EntryLoginFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }
        //TODO: Sharedpreferences ile login yapan?? tut
    fun registerPressed(v: View){
        Navigation.findNavController(v).navigate(R.id.loginToRegisterAction)
    }
    fun loginPressed(email: String, password: String){
        viewModel.login(email, password)
    }
}