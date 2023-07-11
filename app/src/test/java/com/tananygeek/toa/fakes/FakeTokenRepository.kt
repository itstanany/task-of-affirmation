package com.tananygeek.toa.fakes

import com.tananygeek.toa.login.domain.model.Token
import com.tananygeek.toa.login.domain.repository.TokenRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs

class FakeTokenRepository {

    val mock: TokenRepository = mockk(
//        relaxUnitFun = true,
    )

    init {
        coEvery {
            mock.storeToken(any())
        } just runs
    }

    fun verifyTokenStored(token: Token) {
        coVerify {
            mock.storeToken(token)
        }
    }

    fun verifyTokenNotStored() {
        coVerify(exactly = 0) {
            mock.storeToken(any())
        }
    }

//    fun mockSuccessFetchAuthToken() {
//        coEvery {
//            mock.fetchToken()
//        } returns Token(AuthToken("sss"), RefreshToken("ggg"))
//    }
//
//
//    fun mockFailureFetchAuthToken() {
//        coEvery {
//            mock.fetchToken()
//        } returns null
//    }
}
