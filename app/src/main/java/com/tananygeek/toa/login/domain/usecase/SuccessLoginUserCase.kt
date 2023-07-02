package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.LoginResult

class SuccessLoginUserCase : CredentialsLoginUseCase {
    /**
     * This is a fake implementation of sign in use case that is always successful
     */
    override suspend fun invoke(
        credentials: Credentials,
    ): LoginResult {
        return LoginResult.Success
    }
}
