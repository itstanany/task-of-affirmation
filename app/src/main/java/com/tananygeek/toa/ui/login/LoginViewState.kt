package com.tananygeek.toa.ui.login

/**
 * The current state of Login Screen
 *
 * @param[userName] The current username entered in the input field
 * @param[password] The current password entered in the input field
 */
data class LoginViewState(
    val userName: String,
    val password: String,
)
