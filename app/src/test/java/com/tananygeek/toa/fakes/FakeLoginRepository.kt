package com.tananygeek.toa.fakes

import com.tananygeek.toa.core.data.Result
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.LoginResponse
import com.tananygeek.toa.login.domain.repository.LoginRepository
import io.mockk.coEvery
import io.mockk.mockk

/**
 * A fake implementation of [LoginRepository]  that wraps all our mock work.
 * it is a wrapper around the 3rd party mocking library for re-usability, see
 * https://handstandsam.com/2020/06/08/wrapping-mockito-mocks-for-reusability/
 *
 */

class FakeLoginRepository {
    val mock: LoginRepository = mockk()

    /**
     * Mock call to login function of login repository
     */
    fun mockLoginWithCredentials(
        credentials: Credentials,
        result: Result<LoginResponse>,
    ) {
        coEvery {
            mock.login(
                credentials,
            )
        } returns result
    }
}
