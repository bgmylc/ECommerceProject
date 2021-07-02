package com.begumyolcu.ecommerceproject.mainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.entity.User
import com.begumyolcu.ecommerceproject.mainappviewmodel.ProfileFragmentViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val viewModel: ProfileFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav_main)
        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController)

        val loggedUser = intent.getSerializableExtra("user") as User
        viewModel.getUser(loggedUser)

        //TODO: Toolbar sepet ikonu ile sepete gitmeler yapılacak
        //TODO: Sepete eklenince toast çıkarılacak


    }
}