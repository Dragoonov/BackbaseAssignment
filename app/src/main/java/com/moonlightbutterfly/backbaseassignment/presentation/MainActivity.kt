package com.moonlightbutterfly.backbaseassignment.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.moonlightbutterfly.backbaseassignment.R
import com.moonlightbutterfly.backbaseassignment.databinding.ActivityMainBinding
import com.moonlightbutterfly.backbaseassignment.di.AppComponent
import com.moonlightbutterfly.backbaseassignment.di.DaggerAppComponent
import com.moonlightbutterfly.backbaseassignment.presentation.cities.CitiesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerAppComponent.factory().create(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}