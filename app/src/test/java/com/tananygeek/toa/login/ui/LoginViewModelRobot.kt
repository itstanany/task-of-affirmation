package com.tananygeek.toa.login.ui

import com.google.common.truth.Truth.assertThat
import com.tananygeek.toa.fakes.FakeCredentialsLoginUseCase
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.LoginResult

class LoginViewModelRobot {
    private val fakeCredentialsLoginUseCase = FakeCredentialsLoginUseCase()

    private lateinit var viewModel: LoginViewModel

    fun buildViewModel() = apply {
        viewModel = LoginViewModel(
            credentialsLoginUseCase = fakeCredentialsLoginUseCase.mock,
        )
    }

    fun mockLoginResultForCredentials(
        credentials: Credentials,
        result: LoginResult,
    ) = apply {
        fakeCredentialsLoginUseCase.mockResultsForCredentials(
            credentials,
            result,
        )
    }

    fun enterEmail(
        email: String,
    ) = apply {
        viewModel.emailChanged(email)
    }

    fun enterPassword(
        password: String,
    ) = apply {
        viewModel.passwordChanged(password)
    }

    fun clickLoginBtn() = apply {
        viewModel.loginBtnClicked()
    }

    fun clickSignUpBtn() = apply {
        viewModel.signUpBtnClicked()
    }

    fun assertViewState(
        expectedViewState: LoginViewState,
    ) = apply {
        assertThat(
            viewModel.viewState.value,
        ).isEqualTo(
            expectedViewState,
        )
    }
}
