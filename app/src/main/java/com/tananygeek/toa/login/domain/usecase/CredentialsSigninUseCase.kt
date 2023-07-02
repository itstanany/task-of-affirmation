package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.Password
import com.tananygeek.toa.login.domain.model.SignInResult

/**
 * This interface consumes any information required to sign in the user, and attempts to do so.
 */
interface CredentialsSigninUseCase {
    /**
     * This function perform sign in action by the user
     *
     * @param[credentials] Object of [Email] and [Password]
     *
     * @return[SignInResult] Explains whether the sign in attempt is successful or not
     */
    suspend operator fun invoke(
        credentials: Credentials,
    ): SignInResult
}
