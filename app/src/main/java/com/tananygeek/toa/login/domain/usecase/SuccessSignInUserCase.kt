package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.SignInResult

class SuccessSignInUserCase : SignInUseCase {
    /**
     * This is a fake implementation of sign in use case that is always successful
     */
    override suspend fun invoke(email: Email, password: Password): SignInResult {
        return SignInResult.Success
    }
}
