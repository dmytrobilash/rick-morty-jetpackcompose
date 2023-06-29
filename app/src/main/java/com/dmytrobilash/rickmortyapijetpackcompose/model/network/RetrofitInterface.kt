package com.dmytrobilash.rickmortyapijetpackcompose.model.network

import com.dmytrobilash.rickmortyapijetpackcompose.model.model.ResponseDetailed
import com.dmytrobilash.rickmortyapijetpackcompose.model.model.ResponseMain
import retrofit2.http.GET


interface RetrofitInterface {

    @GET("character/1,2,3,4,5,6,7,8,9,10")
    suspend fun getMain(): List<ResponseMain>

    @GET("character")
    suspend fun getDetailed(): ResponseDetailed

}