package com.dmytrobilash.rickmorty.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRickMortyAPI(
    @SerialName("info")
    val info: InfoResponse,
    @SerialName("results")
    val results: List<ResponseMain>
)
