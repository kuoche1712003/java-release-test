package io.kuoche.testapplication.usecase

import io.kuoche.testapplication.presenter.TestPresenter
import io.kuoche.testapplication.repository.TestRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ListTestsUseCase(
    private val testRepository: TestRepository,
) {

    suspend fun execute(presenter: TestPresenter){
        val tests = testRepository.list()
        presenter.present(tests)
    }

}