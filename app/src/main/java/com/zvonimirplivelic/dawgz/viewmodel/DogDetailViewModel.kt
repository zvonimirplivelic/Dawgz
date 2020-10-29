package com.zvonimirplivelic.dawgz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zvonimirplivelic.dawgz.model.DogBreed

class DogDetailViewModel : ViewModel() {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog =
            DogBreed("1", "Corgi", "15 years", "breedGroup", "bredFor", "temperament", "")
        dogLiveData.value = dog
    }
}