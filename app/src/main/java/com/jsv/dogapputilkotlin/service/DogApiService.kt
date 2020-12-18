package com.jsv.dogapputilkotlin.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jsv.dogapputilkotlin.model.DogBreedModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface IDogApi {
    @GET("v1/breeds")
    fun getDogsList(): Deferred<List<DogBreedModel>>
}


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.thedogapi.com")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory()) //Return something different than the default class, replace the call with a coroutine deferred.
    .build()

/*
* A public Api object that exposes the lazy-initialized Retrofit service
* */
object DogApi {
   val retrofitService : IDogApi by lazy {
      retrofit.create(IDogApi::class.java)
   }
}
