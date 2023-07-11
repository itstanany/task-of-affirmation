package com.tananygeek.toa.login.domain.model

@JvmInline
value class AuthToken(val value: String)

@JvmInline
value class RefreshToken(val value: String)

/**
 * @property [authToken] Token used to authenticate the user
 * @property [refreshToken] Token used to refresh the [authToken] if it become
 */
data class Token(
    val authToken: AuthToken,
    val refreshToken: RefreshToken,
)
