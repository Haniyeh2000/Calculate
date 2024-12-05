package com.example.bookread

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class notes(
    val id:Int?=null,
    val title:String,
    @SerializedName("body")

    val body:String
)
