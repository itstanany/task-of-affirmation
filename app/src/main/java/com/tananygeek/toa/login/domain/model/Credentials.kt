package com.tananygeek.toa.login.domain.model

// Inline classes to wrap email and password types
// We just try this feature out and if we hate it later we can remove it
// https://kotlinlang.org/docs/inline-classes.html
@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(private val email: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(private val password: String)

data class Credentials(
    val email: Email,
    val password: Password,
)
