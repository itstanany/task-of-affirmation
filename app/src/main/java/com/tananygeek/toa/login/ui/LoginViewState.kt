package com.tananygeek.toa.login.ui

import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.Password

/**
 * The current state of Login Screen
 *
 * @property[credentials] The current [Email]  and [Password]
 * @property[buttonEnable] Whether Buttons in login screen should be enabled or not
 */
sealed class LoginViewState(
    open val credentials: Credentials,
    val buttonEnable: Boolean = true,
) {
    /**
     * Initial State of login Screen before any user interaction
     */
    object Initial : LoginViewState(credentials = Credentials())

    /**
     * Active State of Login screen
     *
     * @property [credentials] The current [Credentials] entered by the user
     */
    data class Active(
        override val credentials: Credentials,
    ) : LoginViewState(credentials)

    /**
     * Submitting state of login screen
     *
     * @property [credentials] The current [Credentials] entered by the user
     */
    data class Submitting(
        override val credentials: Credentials,
    ) : LoginViewState(
        credentials = credentials,
        buttonEnable = false,
    )

    /**
     * Submitting state of login screen
     *
     * @property [credentials] The current [Credentials] entered by the user.
     * @property [msg] Error message
     */
    data class SubmissionError(
        override val credentials: Credentials,
        val msg: String,
    ) : LoginViewState(credentials)

    /**
     * Submitting state of login screen
     *
     * @property [credentials] The current [Credentials] entered by the user
     * @property [emailInpError] The current error message related to email input
     * @property [passInpError] The current error message related to password input field
     */
    data class InputError(
        override val credentials: Credentials,
        val emailInpError: String? = null,
        val passInpError: String? = null,
    ) : LoginViewState(credentials)
}
