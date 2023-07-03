package com.dmytrobilash.rickmorty.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class ResponseDetailed (
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("status")
    val status: String,
    @SerialName("species")
    val species: String,
    @SerialName("origin")
    val origin: String,
    @SerialName("type")
    val type: String
    )