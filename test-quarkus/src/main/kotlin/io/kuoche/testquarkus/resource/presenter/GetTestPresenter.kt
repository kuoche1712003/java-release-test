package io.kuoche.testquarkus.resource.presenter

import io.kuoche.testapplication.presenter.TestPresenter
import io.kuoche.testdomain.Test
import io.kuoche.testquarkus.resource.viewmodel.TestViewModel

class GetTestPresenter: TestPresenter {
    var viewModel: TestViewModel? = null

    override fun present(tests: List<Test>) {
        viewModel = tests.firstOrNull()?.let {
            TestViewModel(it.id, it.name)
        }
    }

}