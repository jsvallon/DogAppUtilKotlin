package com.jsv.dogapputilkotlin.service

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkDogBreedContainer(val dogBreeds: List<NetworkDogBreedModel>)

/*
* */
@JsonClass(generateAdapter = true)
data class NetworkDogBreedModel(
     val id: Int,
     val name: String,
     val breed_for: String)