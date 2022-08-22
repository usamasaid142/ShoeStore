package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.utils.ShoeviewmodelFactory
import com.udacity.shoestore.viewmodel.ShoeViewmodel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var navController:NavController
    lateinit var viewmodel:ShoeViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       navController = navHostFragment.navController
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)
        val viewmodelfactory=ShoeviewmodelFactory()
        viewmodel= ViewModelProvider(this,viewmodelfactory).get(ShoeViewmodel::class.java)

    }

    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }
}
