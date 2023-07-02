package com.tananygeek.toa.login.domain.model

/**
 * This is the information we expect to be returned from a successful sign in response
 *
 * @param[authToken] This is a unique token that will allow us to authenticate future requests
 * in the application
 */
data class LoginResponse(
    val authToken: String,
)
