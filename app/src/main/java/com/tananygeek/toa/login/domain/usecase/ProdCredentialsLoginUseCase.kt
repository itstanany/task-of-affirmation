package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.core.data.Result
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.InvalidCredentialsException
import com.tananygeek.toa.login.domain.model.LoginResult
import com.tananygeek.toa.login.domain.repository.LoginRepository

/**
 * A concrete implementation of [CredentialsLoginUseCase] that will request logging in via
 * [LoginRepository]
 */
class ProdCredentialsLoginUseCase(
    private val loginRepository: LoginRepository,
) : CredentialsLoginUseCase {

    override suspend fun invoke(
        credentials: Credentials,
    ): LoginResult {
        // I don't understand how repository return a result when it not actually implemented yet
        // I think he implemented it only to pass the tests
//        in tests, loginRepository.login is mocked and has a pre-defined return value
        val repoResult = loginRepository.login(
            credentials,
        )

        return when (repoResult) {
            is Result.Success -> {
                return LoginResult.Success
            }
            is Result.Error -> {
                loginResultError(repoResult)
            }
        }
    }

    /**
     * Check different error scenarios of the [repoResult] and
     * maps it an appropriate [LoginResult.Failure]
     */
    private fun loginResultError(repoResult: Result.Error) =
        when (repoResult.error) {
            is InvalidCredentialsException -> {
                LoginResult.Failure.InvalidCredentials
            }

            else -> {
                LoginResult.Failure.Unknown
            }
        }
}
