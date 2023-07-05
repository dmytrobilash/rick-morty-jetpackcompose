package com.dmytrobilash.rickmorty.domain.usecase

import com.dmytrobilash.rickmorty.domain.repository.RepositoryIF

class MainUseCase (private val repository: RepositoryIF) {
    suspend fun execute(page: Int) = repository.getMain(page)
}
