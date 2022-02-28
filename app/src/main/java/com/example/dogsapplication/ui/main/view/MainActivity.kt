package com.example.dogsapplication.ui.main.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.dogsapplication.R
import com.example.dogsapplication.databinding.ActivityMainBinding
import com.example.dogsapplication.ui.main.adapter.DogAdapter
import com.example.dogsapplication.ui.main.viewmodel.MainViewModel
import com.example.dogsapplication.utils.Status
import com.example.dogsapplication.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setTheme(R.style.Theme_DogsApplication)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        listener()
        setRecycler()
        setUpObservable()
    }

    private fun listener(){
        binding.arrowBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setRecycler(){
        adapter = DogAdapter()
        binding.rvDogs.setHasFixedSize(true)
        binding.rvDogs.adapter = adapter
    }

    private fun setUpObservable(){
        viewModel.getDogsFromService()
        viewModel.dogs.observe(this, { response ->
            binding.resource = response //Set dataBinding

            when(response.status){
                Status.LOADING -> {
                    //Show ProgressBar
                }
                Status.SUCCESS -> adapter.addItems(response.data ?: emptyList())

                Status.ERROR -> {
                    toast(response.message ?: "")
                }
            }
        })
    }
}