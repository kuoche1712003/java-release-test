package io.kuoche.testquarkus.resource.presenter

import io.kuoche.testapplication.presenter.TestPresenter
import io.kuoche.testdomain.Test
import io.kuoche.testquarkus.resource.viewmodel.TestViewModel

class ListTestsPresenter: TestPresenter {
    lateinit var viewModel: List<TestViewModel>
    override fun present(tests: List<Test>) {
        viewModel = tests.map {
            TestViewModel(it.id, it.name)
        }
    }
}
