package com.dmytrobilash.rickmorty.data.network.network

import com.dmytrobilash.rickmorty.data.network.model.model.ResponseDetailed
import com.dmytrobilash.rickmorty.data.network.model.model.ResponseMain
import com.dmytrobilash.rickmorty.data.network.model.model.ResponseRickMortyAPI
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("character")
    suspend fun getMain(): ResponseRickMortyAPI

    @GET("character/{character_id}")
    suspend fun getDetailed(
        @Path("character_id") characterId: Int,
    ): ResponseDetailed
}