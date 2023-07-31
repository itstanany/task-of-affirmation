package com.tananygeek.toa.fakes

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.LoginResult
import com.tananygeek.toa.login.domain.usecase.CredentialsLoginUseCase
import io.mockk.coEvery
import io.mockk.mockk

class FakeCredentialsLoginUseCase {
    val mock: CredentialsLoginUseCase = mockk()

    fun mockResultsForCredentials(
        credentials: Credentials,
        result: LoginResult,
    ) {
        coEvery {
            mock(credentials)
        } returns result
    }
}
