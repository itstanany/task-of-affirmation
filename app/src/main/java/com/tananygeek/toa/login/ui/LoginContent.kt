package com.tananygeek.toa.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.tananygeek.toa.R
import com.tananygeek.toa.core.ui.components.PrimaryButton
import com.tananygeek.toa.core.ui.components.SecondaryButton
import com.tananygeek.toa.core.ui.components.TOATextField
import com.tananygeek.toa.core.ui.components.VerticalSpacer
import com.tananygeek.toa.core.ui.theme.TasksOfAffirmationTheme
import com.tananygeek.toa.core.ui.utility.PreviewNightLight
import com.tananygeek.toa.login.domain.model.Credentials
import com.tananygeek.toa.login.domain.model.Email
import com.tananygeek.toa.login.domain.model.Password

@Suppress("TopLevelPropertyNaming")
private const val APP_LOGO_FRACTION_WIDTH = 0.75F

/**
 * This composable maintains the UI for the Sign In screen.
 *
 * @param [viewState] The current state of Login screen to render.
 * @param [onEmailChanged] A callback invoked when user inputs email.
 * @param [onUserPasswordChanged] A callback invoked when user inputs password.
 * @param [onSignInClicked] A callback invoked when user hits sign in button.
 * @param [onSignUpClicked] A callback invoked when user hits sign up button.
 */
@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onUserPasswordChanged: (String) -> Unit,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Box(
            modifier = Modifier
                // bottom padding to be added in case of [bottomBar] used
                .padding(it),
        ) {
            LogoInpColumn(
                viewState,
                onEmailChanged,
                onUserPasswordChanged,
                onSignInClicked,
                onSignUpClicked,
            )

            CircularProgressIndicator(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center),
            )
        }
    }
}

@Composable
private fun LogoInpColumn(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onUserPasswordChanged: (String) -> Unit,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                dimensionResource(
                    id = R.dimen.screen_padding,
                ),
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier
                .weight(1F),
        )

        AppLogo()

        Spacer(
            modifier = Modifier
                .weight(1F),
        )

        EmailInput(
            text = viewState.credentials.email.value,
            onTextChanged = onEmailChanged,
            errMsg = (viewState as? LoginViewState.InputError)?.emailInpError,
//                    errMsg = if (viewState is LoginViewState.InputError) {
//                        viewState.emailInpError
//                    }
        )

        VerticalSpacer(height = 12.dp)

        PasswordInput(
            text = viewState.credentials.password.value,
            onTextChanged = onUserPasswordChanged,
            errMsg = (viewState as? LoginViewState.InputError)?.passInpError,
        )

        if (viewState is LoginViewState.SubmissionError) {
            Text(
                text = viewState.msg,
            )
        }

        VerticalSpacer(height = 48.dp)

        SignInBtn(
            onClick = onSignInClicked,
            enabled = viewState.buttonEnable,
        )

        VerticalSpacer(height = 12.dp)

        SignUpBtn(
            onClick = onSignUpClicked,
            enabled = viewState.buttonEnable,
        )
    }
}

@Composable
private fun SignUpBtn(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    SecondaryButton(
        text = stringResource(
            R.string.sign_up,
        ),
        onClick = onClick,
        contentColor = MaterialTheme.colorScheme.primary,
        enabled = enabled,
    )
}

@Composable
private fun SignInBtn(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    PrimaryButton(
        text = stringResource(
            R.string.sign_in,
        ),
        onClick = onClick,
        backgroundColor = MaterialTheme.colorScheme.primary,
        enabled = enabled,
    )
}

@Composable
private fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errMsg: String?,
) {
    TOATextField(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(
            R.string.password,
        ),
        errMsg = errMsg,
        visualTransformation = PasswordVisualTransformation(),
    )
}

@Composable
private fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errMsg: String?,
) {
    TOATextField(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(
            R.string.email,
        ),
        errMsg = errMsg,
    )
}

@Composable
private fun AppLogo() {
    Image(
        painter = painterResource(
            id = R.drawable.ic_launcher_foreground,
        ),
        contentDescription = stringResource(
            R.string.app_logo_content_description,
        ),
        modifier = Modifier
            .fillMaxWidth(APP_LOGO_FRACTION_WIDTH),
    )
}

@PreviewNightLight
@Composable
private fun EmptyLoginContentPreview(
    @PreviewParameter(LoginViewStateProvider::class)
    loginViewState: LoginViewState,
) {
    TasksOfAffirmationTheme {
        LoginContent(
            viewState = loginViewState,
            onEmailChanged = {},
            onUserPasswordChanged = {},
            onSignInClicked = {},
            onSignUpClicked = {},
        )
    }
}

class LoginViewStateProvider : PreviewParameterProvider<LoginViewState> {
    override val values: Sequence<LoginViewState>
        get() {
            val activeCredentials = Credentials(
                Email("tt@gmail.com"),
                Password("aa1122"),
            )

            return sequenceOf(
                LoginViewState.Initial,
                LoginViewState.Active(activeCredentials),
                LoginViewState.Submitting(activeCredentials),
                LoginViewState.SubmissionError(
                    credentials = activeCredentials,
                    msg = "Something Went Wrong, Sorry",
                ),
                LoginViewState.InputError(
                    credentials = activeCredentials,
//                    emailInpError = "Please, enter a valid email",
                    passInpError = "Wrong pass, try again",
                ),

            )
        }
}
