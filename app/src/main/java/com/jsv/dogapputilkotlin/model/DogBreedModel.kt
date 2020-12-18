package com.jsv.dogapputilkotlin.model

import com.squareup.moshi.Json

data class DogBreedModel(
                         @Json (name= "bred_for") val bredFor: String ? = null,
                         val id: Int,
                         val name: String) {

}

