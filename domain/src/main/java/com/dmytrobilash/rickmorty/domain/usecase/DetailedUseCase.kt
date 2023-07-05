package com.dmytrobilash.rickmorty.domain.usecase

import com.dmytrobilash.rickmorty.domain.repository.RepositoryIF

class DetailedUseCase(private val repository: RepositoryIF) {
    suspend fun execute(id: Int) = repository.getDetailed(id)
}