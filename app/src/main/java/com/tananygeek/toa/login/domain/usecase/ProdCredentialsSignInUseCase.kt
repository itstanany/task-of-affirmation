package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.SignInResult
import com.tananygeek.toa.login.domain.repository.SignInRepository

class ProdCredentialsSignInUseCase(
    private val signinRepository: SignInRepository,
) : CredentialsSigninUseCase {

    override suspend fun invoke(
        credentials: Credentials,
    ): SignInResult {
        TODO("Not yet implemented")
    }
}
