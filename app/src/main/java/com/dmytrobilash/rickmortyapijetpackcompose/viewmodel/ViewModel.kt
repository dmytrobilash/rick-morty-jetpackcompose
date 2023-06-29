package com.dmytrobilash.rickmortyapijetpackcompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmytrobilash.rickmortyapijetpackcompose.model.model.ResponseMain
import com.dmytrobilash.rickmortyapijetpackcompose.model.network.RetrofitImplementation
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var listResponse: List<ResponseMain> by mutableStateOf(emptyList())

    init {
        getDataMain()
    }

    private fun getDataMain() {
        viewModelScope.launch {
            try {
                val service = RetrofitImplementation().service
                val response = service.getMain()
                listResponse = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}