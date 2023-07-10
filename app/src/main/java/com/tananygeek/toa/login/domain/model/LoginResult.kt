package com.tananygeek.toa.login.domain.model

/**
 * A class that returns the result of a SignIn attempt by the user
 */
sealed class LoginResult {
    /**
     * User successfully signed in.
     */
    object Success : LoginResult()

    /**
     * Failure SignIn attempt
     */
    sealed class Failure : LoginResult() {
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
