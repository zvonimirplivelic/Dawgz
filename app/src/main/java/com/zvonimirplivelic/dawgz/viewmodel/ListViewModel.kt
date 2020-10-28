package com.zvonimirplivelic.dawgz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zvonimirplivelic.dawgz.model.DogBreed

class ListViewModel : ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 =
            DogBreed("1", "Corgi", "15 years", "breedGroup", "bredFor", "temperament", "")
        val dog2 =
            DogBreed("2", "Labrador", "15 years", "breedGroup", "bredFor", "temperament", "")
        val dog3 =
            DogBreed("3", "Rotweiler", "15 years", "breedGroup", "bredFor", "temperament", "")

        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
    }
}