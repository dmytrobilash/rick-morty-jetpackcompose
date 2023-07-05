package com.dmytrobilash.rickmorty.data.network.network

import com.dmytrobilash.rickmorty.data.network.model.ResponseDetailed
import com.dmytrobilash.rickmorty.data.network.model.ResponseRickMortyAPI
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitInterface {

    @GET("character/?page={page}")
    suspend fun getMain(page: Int): ResponseRickMortyAPI

    @GET("character/{character_id}")
    suspend fun getDetailed(
        @Path("character_id") characterId: Int,
    ): ResponseDetailed
}