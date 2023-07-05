package com.dmytrobilash.rickmorty.domain.model

class ResponseRickMortyDomain(
    val info: InfoResponse,
    val results: List<ResponseMain>
)