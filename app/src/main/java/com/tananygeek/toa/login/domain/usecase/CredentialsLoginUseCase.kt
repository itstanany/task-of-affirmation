package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.Password
import com.tananygeek.toa.login.domain.model.LoginResult

/**
 * This interface consumes any information required to sign in the user, and attempts to do so.
 */
interface CredentialsLoginUseCase {
    /**
     * This function perform sign in action by the user
     *
     * @param[credentials] Object of [Email] and [Password]
     *
     * @return[LoginResult] Explains whether the sign in attempt is successful or not
     */
    suspend operator fun invoke(
        credentials: Credentials,
    ): LoginResult
}
