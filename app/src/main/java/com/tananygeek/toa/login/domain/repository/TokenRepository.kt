package com.tananygeek.toa.login.domain.repository

import com.tananygeek.toa.login.domain.model.Token

/**
 * TokenRepository is responsible for storing/fetching user's token used for authentication
 */
interface TokenRepository {

    /**
     * Store [token] for latter retrieval on need basis
     * @param [token] Token to be stored
     */
    suspend fun storeToken(
        token: Token,
    )

    /**
     * Fetch the token of the logged user, if we have onc saved
     *
     * @return The auth token or null if nothing is stored
     */
    suspend fun fetchToken(): Token?
}
