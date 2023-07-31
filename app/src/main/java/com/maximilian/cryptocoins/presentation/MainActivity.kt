package com.maximilian.cryptocoins.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maximilian.cryptocoins.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var navController: NavController
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.mainFragment) as NavHostFragment
//
//        navController = navHostFragment.navController
//
//        setupActionBarWithNavController(navController)
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
//}