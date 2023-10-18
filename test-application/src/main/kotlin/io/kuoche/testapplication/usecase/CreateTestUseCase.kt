package io.kuoche.testapplication.usecase

import io.kuoche.testapplication.presenter.TestPresenter
import io.kuoche.testapplication.repository.TestRepository
import io.kuoche.testdomain.Test
import jakarta.enterprise.context.ApplicationScoped
import java.util.*

@ApplicationScoped
class CreateTestUseCase(
    private val testRepository: TestRepository
) {

    suspend fun execute(input: Input, presenter: TestPresenter) {
        val tests  = testRepository.add(
            Test(
                UUID.randomUUID().toString(),
                input.name
            )
        ).let { listOf(it) }
        presenter.present(tests)
    }


    data class Input(
        val name: String
    )
}