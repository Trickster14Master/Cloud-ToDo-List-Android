package ru.example.cloudtodolistandroid.domain.models.user

data class ResponseRegistrationUser(
    val email: String,
    val username: String,
    val id: Int,
)