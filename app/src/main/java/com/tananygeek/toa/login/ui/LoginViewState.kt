package com.tananygeek.toa.login.ui

/**
 * The current state of Login Screen
 *
 * @param[email] The current email entered in the input field
 * @param[password] The current password entered in the input field
 */
data class LoginViewState(
    val email: String,
    val password: String,
)
