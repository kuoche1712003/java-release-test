package io.kuoche.testquarkus.repository.dao

import io.kuoche.testquarkus.repository.data.TestData
import jakarta.enterprise.context.ApplicationScoped
import java.util.concurrent.ConcurrentHashMap


@ApplicationScoped
class TestDAO {
    private val map = ConcurrentHashMap<String, TestData>()

    suspend fun list(): List<TestData>{
        return map.values.toList()
    }

    suspend fun findById(id: String): TestData?{
        return map[id]
    }

    suspend fun persist(testData: TestData){
        map[testData.id] = testData
    }

}