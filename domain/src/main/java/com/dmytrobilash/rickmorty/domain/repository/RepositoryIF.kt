package com.dmytrobilash.rickmorty.domain.repository

import com.dmytrobilash.rickmorty.domain.model.ResponseDetailedDomain
import com.dmytrobilash.rickmorty.domain.model.ResponseRickMortyDomain

interface RepositoryIF {
    suspend fun getMain(page: Int): ResponseRickMortyDomain
    suspend fun getDetailed(id: Int): ResponseDetailedDomain
}