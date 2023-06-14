package com.tananygeek.toa.login.domain.model

/**
 * A class that returns the result of a SignIn attempt by the user
 */
sealed class SignInResult {
    /**
     * User successfully signed in.
     */
    object Success : SignInResult()

    /**
     * Failure SignIn attempt
     */
    sealed class Failure : SignInResult() {
        /**
         * User passed credentials not found(matching) or invalid
         */
        object InvalidCredentials : Failure()

        /**
         * Any other failure attempt of signIn
         */
        object Unknown : Failure()
    }
}
