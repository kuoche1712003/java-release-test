package io.kuoche.testapplication.repository

import io.kuoche.testdomain.Test

interface TestRepository {
    suspend fun list(): List<Test>

    suspend fun getById(id: String): Test?
    suspend fun add(test: Test): Test
}