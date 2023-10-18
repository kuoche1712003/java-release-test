package io.kuoche.testquarkus.repository

import io.kuoche.testapplication.repository.TestRepository
import io.kuoche.testdomain.Test
import io.kuoche.testquarkus.repository.dao.TestDAO
import io.kuoche.testquarkus.repository.data.TestData
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class MemoryTestRepository(
    private val testDAO: TestDAO
): TestRepository {
    override suspend fun list(): List<Test> {
        return testDAO.list().map { it.toDomain() }
    }

    override suspend fun getById(id: String): Test? {
        return testDAO.findById(id)?.toDomain()
    }

    override suspend fun add(test: Test): Test {
        testDAO.persist(test.toData())
        return test
    }

    private fun Test.toData(): TestData{
        return TestData(id, name)
    }

    private fun TestData.toDomain(): Test{
        return Test(id, name)
    }
}