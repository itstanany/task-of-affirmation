package com.tananygeek.toa.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.tananygeek.toa.core.data.Result
import com.tananygeek.toa.fakes.FakeLoginRepository
import com.tananygeek.toa.fakes.FakeTokenRepository
import com.tananygeek.toa.login.domain.model.AuthToken
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.InvalidCredentialsException
import com.tananygeek.toa.login.domain.model.LoginResponse
import com.tananygeek.toa.login.domain.model.LoginResult
import com.tananygeek.toa.login.domain.model.Password
import com.tananygeek.toa.login.domain.model.RefreshToken
import com.tananygeek.toa.login.domain.model.Token
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Here we test Success and Failure login not the "invoke" method of the actual use case
 */
class ProdCredentialsLoginUseCaseTest {
    @Test
    fun testSuccessfulLogin() = runTest {
        val email = Email("john@example.com")
        val password = Password("123456")
        val inputCredentials = Credentials(
            email,
            password,
        )
        val token = Token(AuthToken("sss"), RefreshToken("ggg"))
        val response = LoginResponse(
            token,
        )

        val loginResponse = Result.Success(response)

        val loginRepository: FakeLoginRepository = FakeLoginRepository().apply {
            // setup how login function should behave in this test case
            mockLoginWithCredentials(
                credentials = inputCredentials,
                result = loginResponse,
            )
        }

        val tokenRepository = FakeTokenRepository()

        val useCase = ProdCredentialsLoginUseCase(
            loginRepository.mock,
            tokenRepository.mock,
        )
        val result = useCase(
            inputCredentials,
        )

        assertThat(
            result,
        ).isEqualTo(
            LoginResult.Success,
        )
        tokenRepository.verifyTokenStored(
            token,
        )
    }

    @Test
    fun testUnknownFailureLogin() = runTest {
        val email = Email("john@example.com")
        val password = Password("123456")
        val inputCredentials = Credentials(
            email,
            password,
        )

        val loginResponse = Result
            .Error(
                Throwable("Sorry, Error Happened"),
            )

        val loginRepository: FakeLoginRepository = FakeLoginRepository().apply {
            // setup how login function should behave in this test case
            mockLoginWithCredentials(
                credentials = inputCredentials,
                result = loginResponse,
            )
        }

        val tokenRepository = FakeTokenRepository()

        val useCase = ProdCredentialsLoginUseCase(
            loginRepository.mock,
            tokenRepository.mock,
        )
        val result = useCase(
            inputCredentials,
        )

        assertThat(
            result,
        ).isEqualTo(
            LoginResult.Failure.Unknown,
        )
        tokenRepository.verifyTokenNotStored()
    }

    @Test
    fun testInvalidCredentialsLogin() = runTest {
        val email = Email("john@example.com")
        val password = Password("123456")
        val inputCredentials = Credentials(
            email,
            password,
        )

        val loginResponse = Result
            .Error(
                InvalidCredentialsException(),
            )

        val loginRepository: FakeLoginRepository = FakeLoginRepository().apply {
            // setup how login function should behave in this test case
            mockLoginWithCredentials(
                credentials = inputCredentials,
                result = loginResponse,
            )
        }

        val tokenRepository = FakeTokenRepository()

        val useCase = ProdCredentialsLoginUseCase(
            loginRepository.mock,
            tokenRepository.mock,
        )
        val result = useCase(
            inputCredentials,
        )

        assertThat(
            result,
        ).isEqualTo(
            LoginResult.Failure.InvalidCredentials,
        )

        tokenRepository.verifyTokenNotStored()
    }
}
