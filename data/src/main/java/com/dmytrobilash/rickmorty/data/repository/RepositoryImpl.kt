package com.dmytrobilash.rickmorty.data.repository

import com.dmytrobilash.rickmorty.data.mapper.MapperMainResponse
import com.dmytrobilash.rickmorty.data.network.model.ResponseMain
import com.dmytrobilash.rickmorty.data.network.network.RetrofitInterface
import com.dmytrobilash.rickmorty.domain.model.ResponseDetailedDomain
import com.dmytrobilash.rickmorty.domain.model.ResponseRickMortyDomain
import com.dmytrobilash.rickmorty.domain.repository.RepositoryIF

class RepositoryImpl(private val dataSource: RetrofitInterface) : RepositoryIF {

    override suspend fun getMain(page: Int) : ResponseRickMortyDomain {
        return MapperMainResponse.toDomainMainResponse(dataSource.getMain(page))
    }

    override suspend fun getDetailed(id: Int): ResponseDetailedDomain {
        return MapperMainResponse.toDomainDetailedResponse(dataSource.getDetailed(id))
    }
}