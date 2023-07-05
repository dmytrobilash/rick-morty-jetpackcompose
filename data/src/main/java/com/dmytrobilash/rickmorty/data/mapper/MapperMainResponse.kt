package com.dmytrobilash.rickmorty.data.mapper

import com.dmytrobilash.rickmorty.data.network.model.ResponseDetailed
import com.dmytrobilash.rickmorty.data.network.model.ResponseRickMortyAPI
import com.dmytrobilash.rickmorty.domain.model.ResponseDetailedDomain
import com.dmytrobilash.rickmorty.domain.model.ResponseRickMortyDomain
import kotlinx.serialization.SerialName

object MapperMainResponse {

    fun toDomainMainResponse(responseRickMorty : ResponseRickMortyAPI): ResponseRickMortyDomain =
    ResponseRickMortyDomain(
        responseRickMorty.info,
        responseRickMorty.results
    )

    fun toDomainDetailedResponse(responseDetailed: ResponseDetailed) : ResponseDetailedDomain =
        ResponseDetailedDomain(
            responseDetailed.image,
            responseDetailed.name,
            responseDetailed.gender,
            responseDetailed.status,
            responseDetailed.species,
            responseDetailed.origin,
            responseDetailed.type
        )
}