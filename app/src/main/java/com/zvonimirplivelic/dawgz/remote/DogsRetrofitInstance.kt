package com.zvonimirplivelic.dawgz.remote

import com.zvonimirplivelic.dawgz.model.DogBreed
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogsRetrofitInstance {
    private val BASE_URL = "https://raw.githubusercontent.com"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(DogsApi::class.java)

    fun getDogs(): Single<List<DogBreed>> {
        return api.getDogsList()
    }
}