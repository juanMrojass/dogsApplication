package com.example.dogsapplication.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsapplication.data.model.DogModelItem
import com.example.dogsapplication.data.repository.DogRepository
import com.example.dogsapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

    val dogs = MutableLiveData<Resource<List<DogModelItem>>>()

    fun getDogsFromService() {
        viewModelScope.launch {
            dogs.postValue(Resource.loading(null))

            val result = repository.invoke()

            if (!result.isNullOrEmpty()) {
                dogs.postValue(Resource.success(result))

            } else {
                dogs.postValue(Resource.error("Ocurrió un error", null))
            }
        }
    }
}