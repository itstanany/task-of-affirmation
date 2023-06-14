package com.tananygeek.toa.login.domain.usecase

import com.tananygeek.toa.login.domain.model.SignInResult

// Inline classes to wrap email and password types
// We just try this feature out and if we hate it later we can remove it
// https://kotlinlang.org/docs/inline-classes.html
@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(private val email: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(private val password: String)

/**
 * This interface consumes any information required to sign in the user, and attempts to do so.
 */
interface SignInUseCase {
    /**
     * This function perform sign in action by the user
     *
     * @param[email] The current email [Email] entered in the input field
     * @param[password] The current password [Password] entered in the input field
     *
     * @return[SignInResult] Explains whether the sign i attempt is successful or not
     */
    suspend operator fun invoke(
        email: Email,
        password: Password,
    ): SignInResult
}
