package com.tananygeek.toa.login.domain.model

// Inline classes to wrap email and password types
// We just try this feature out and if we hate it later we can remove it
// https://kotlinlang.org/docs/inline-classes.html
@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(val value: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(val value: String)

data class Credentials(
    val email: Email = Email(""),
    val password: Password = Password(""),
)
