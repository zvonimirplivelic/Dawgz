package com.zvonimirplivelic.dawgz.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zvonimirplivelic.dawgz.database.DogDatabase
import com.zvonimirplivelic.dawgz.model.DogBreed
import kotlinx.coroutines.launch

class DogDetailViewModel(application: Application) : DogBaseViewModel(application) {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        launch {
            dogLiveData.value = DogDatabase(getApplication()).dogDao().getDog(uuid)
        }
    }
}