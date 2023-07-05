package com.dmytrobilash.rickmorty.domain.model


data class InfoResponse(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)

