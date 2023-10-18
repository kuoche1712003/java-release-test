package io.kuoche.testapplication.presenter

import io.kuoche.testdomain.Test

interface TestPresenter {
    fun present(tests: List<Test>)
}