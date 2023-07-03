package com.dmytrobilash.rickmorty.data.network.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ResponseMain(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("species")
    val species: String?,
    @SerialName("image")
    val image: String?
)