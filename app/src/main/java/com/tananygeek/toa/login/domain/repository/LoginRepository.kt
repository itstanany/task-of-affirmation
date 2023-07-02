package com.tananygeek.toa.login.domain.repository

import com.tananygeek.toa.core.data.Result
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.LoginResponse

/**
 * The data layer for any request related to logging in the user
 */
interface LoginRepository {

    /**
     * Try to Sign in the user
     *
     * @param [credentials]: user credentials of Email and password
     *
     * @return A [Result] that contains the [LoginResponse] if successful or an error otherwise
     */
    suspend fun login(
        credentials: Credentials,
    ): Result<LoginResponse>
}
