package com.tananygeek.toa.login.ui

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.Password
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var testRobot: LoginViewModelRobot

    private val defCredentials = Credentials(
        email = Email("tananyIO@gmail.com"),
        password = Password("123456"),
    )

    @Before
    fun setUp() {
        testRobot = LoginViewModelRobot()
    }

    @Test
    fun testInitialState() {
        testRobot
            .buildViewModel()
            .assertViewState(
                LoginViewState.Initial,
            )
    }

    @Test
    fun testUpdateCredentials() {
        testRobot
            .buildViewModel()
            .enterEmail(defCredentials.email.value)
            .enterPassword(defCredentials.password.value)
            .assertViewState(
                LoginViewState.Active(
                    defCredentials,
                ),
            )
    }
}
