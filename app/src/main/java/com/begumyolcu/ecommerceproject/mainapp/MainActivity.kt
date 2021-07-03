package com.begumyolcu.ecommerceproject.mainapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.begumyolcu.ecommerceproject.R
import com.begumyolcu.ecommerceproject.entity.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav_main)
        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController)

        val loggedUser = intent.getSerializableExtra("user") as User

        val pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref.edit()

        val userPreference: UserPreference = UserPreference.getInstance(applicationContext)!!
        userPreference.saveData("user_name", loggedUser.name_surname)
        userPreference.saveData("user_email", loggedUser.mail_address)
        userPreference.saveData("user_phone", loggedUser.phone)





        editor.apply()
    }
}