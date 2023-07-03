package com.dmytrobilash.rickmortyapijetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmytrobilash.rickmorty.data.network.model.model.ResponseDetailed
import com.dmytrobilash.rickmorty.data.network.model.network.RetrofitImplementation
import kotlinx.coroutines.launch

class DetailedPersonInfoViewModel : ViewModel() {
    var responseDetailed: com.dmytrobilash.rickmorty.data.network.model.model.ResponseDetailed? = null

    init {
        getDetailed()
    }

    private fun getDetailed() {
        viewModelScope.launch {
            try {
                val service = com.dmytrobilash.rickmorty.data.network.model.network.RetrofitImplementation().service
                responseDetailed = service.getDetailed(1)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}