package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.LoginResult
import com.tananygeek.toa.login.domain.repository.LoginRepository

class ProdCredentialsLoginUseCase(
    private val signinRepository: LoginRepository,
) : CredentialsLoginUseCase {

    override suspend fun invoke(
        credentials: Credentials,
    ): LoginResult {
        TODO("Not yet implemented")
    }
}
