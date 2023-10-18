package io.kuoche.testapplication.usecase

import io.kuoche.testapplication.presenter.TestPresenter
import io.kuoche.testapplication.repository.TestRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetTestUseCase(
    private val testRepository: TestRepository
) {
    suspend fun execute(input: Input, presenter: TestPresenter){
        val tests = testRepository.getById(input.id)
            ?.let { listOf(it) }
            ?: listOf()
        presenter.present(tests)
    }

    data class Input(val id: String)
}