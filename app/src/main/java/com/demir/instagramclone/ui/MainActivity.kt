package com.demir.instagramclone.ui

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.demir.instagramclone.R
import com.demir.instagramclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController=Navigation.findNavController(this,R.id.fragmentContainerView)
        binding.bottomNavigationBar.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(object :NavController.OnDestinationChangedListener{
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?,
            ) {
                when(destination.id){
                    R.id.storyDetailFragment->{binding.bottomNavigationBar.visibility= View.GONE}
                    else->{binding.bottomNavigationBar.visibility= View.VISIBLE}
                }
            }

        })
        binding.bottomNavigationBar.setOnItemSelectedListener{ menuItem ->
            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    binding.bottomNavigationBar.setBackgroundColor(resources.getColor(android.R.color.white))
                    binding.bottomNavigationBar.itemIconTintList = ColorStateList.valueOf(resources.getColor(android.R.color.black))
                    true
                }
                R.id.searchFragment -> {
                    navController.navigate(R.id.searchFragment)
                    binding.bottomNavigationBar.setBackgroundColor(resources.getColor(android.R.color.white))
                    binding.bottomNavigationBar.itemIconTintList = ColorStateList.valueOf(resources.getColor(android.R.color.black))
                    true
                }
                R.id.sharingFragment -> {
                    navController.navigate(R.id.sharingFragment)
                    binding.bottomNavigationBar.setBackgroundColor(resources.getColor(android.R.color.white))
                    binding.bottomNavigationBar.itemIconTintList = ColorStateList.valueOf(resources.getColor(android.R.color.black))
                    true
                }

                R.id.reelsFragment -> {
                    navController.navigate(R.id.reelsFragment)
                    binding.bottomNavigationBar.setBackgroundColor(resources.getColor(android.R.color.black))
                    binding.bottomNavigationBar.itemIconTintList = ColorStateList.valueOf(resources.getColor(android.R.color.white))
                    true
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    binding.bottomNavigationBar.setBackgroundColor(resources.getColor(android.R.color.white))
                    binding.bottomNavigationBar.itemIconTintList = ColorStateList.valueOf(resources.getColor(android.R.color.black))
                    true
                }

                else -> true
            }
        }

    }
}
