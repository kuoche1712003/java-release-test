package io.kuoche.testquarkus.resource.presenter

import io.kuoche.testapplication.presenter.TestPresenter
import io.kuoche.testdomain.Test
import io.kuoche.testquarkus.resource.TestResource
import jakarta.ws.rs.core.UriInfo
import java.net.URI

class AddTestPresenter(val uriInfo: UriInfo): TestPresenter{
    lateinit var viewModel: URI

    override fun present(tests: List<Test>) {
        viewModel = uriInfo.baseUriBuilder
            .path(TestResource::class.java)
            .path(TestResource::class.java, TestResource::getTest.name)
            .build(tests.first().id)
    }

}