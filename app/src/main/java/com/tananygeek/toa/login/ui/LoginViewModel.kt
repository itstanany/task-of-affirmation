package com.tananygeek.toa.login.ui

import androidx.lifecycle.ViewModel
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.Password
import com.tananygeek.toa.login.domain.usecase.CredentialsLoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Login View Model to contain business login of login screen
 *
 * @property[credentialsLoginUseCase] It is [CredentialsLoginUseCase]
 */
class LoginViewModel(
    val credentialsLoginUseCase: CredentialsLoginUseCase,
) : ViewModel() {
    private val _viewState: MutableStateFlow<LoginViewState> = MutableStateFlow(LoginViewState.Initial)

    val viewState: StateFlow<LoginViewState> = _viewState

    fun emailChanged(
        email: String,
    ) {
        val currentCredentials = _viewState.value.credentials

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdateEmail(
                email,
            ),
        )
    }

    fun passwordChanged(
        password: String,
    ) {
        val currentCredentials = _viewState.value.credentials

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatePass(
                password,
            ),
        )
    }

    fun loginBtnClicked() {
        TODO()
    }

    fun signUpBtnClicked() {
        TODO()
    }
}

private fun Credentials.withUpdateEmail(email: String): Credentials {
    return this.copy(
        email = Email(email),
    )
}

private fun Credentials.withUpdatePass(pass: String): Credentials {
    return this.copy(
        password = Password(pass),
    )
}
