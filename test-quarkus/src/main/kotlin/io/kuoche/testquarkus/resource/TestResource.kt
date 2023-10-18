package io.kuoche.testquarkus.resource

import io.kuoche.testapplication.usecase.CreateTestUseCase
import io.kuoche.testapplication.usecase.GetTestUseCase
import io.kuoche.testquarkus.resource.presenter.AddTestPresenter
import io.kuoche.testquarkus.resource.presenter.GetTestPresenter
import io.kuoche.testquarkus.resource.viewmodel.TestViewModel
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.UriInfo

@Path("/api/v1.0/tests")
class TestResource(
    private val createTestUseCase: CreateTestUseCase,
    private val getTestUseCase: GetTestUseCase,
    @Context private val uriInfo: UriInfo,
) {

    @GET
    @Path("/{id}")
    suspend fun getTest(
        @PathParam("id") id: String
    ): TestViewModel {
        val presenter = GetTestPresenter()
        getTestUseCase.execute(GetTestUseCase.Input(id), presenter)
        return presenter.viewModel
            ?: throw NotFoundException("not found")
    }

    @POST
    suspend fun add(request: AddTestRequest): Response{
        val presenter = AddTestPresenter(uriInfo)
        createTestUseCase.execute(CreateTestUseCase.Input(request.name), presenter)
        return Response.created(presenter.viewModel).build()
    }

    data class AddTestRequest(val name: String)
}