package com.zvonimirplivelic.dawgz.remote

import com.zvonimirplivelic.dawgz.model.DogBreed
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface DogsApi {
    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogsList(): Single<List<DogBreed>>
}