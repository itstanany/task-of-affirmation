package com.tananygeek.toa.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tananygeek.toa.R
import com.tananygeek.toa.ui.components.PrimaryButton
import com.tananygeek.toa.ui.components.SecondaryButton
import com.tananygeek.toa.ui.components.TOATextField
import com.tananygeek.toa.ui.core.VerticalSpacer
import com.tananygeek.toa.ui.theme.TasksOfAffirmationTheme
import com.tananygeek.toa.ui.utility.PreviewNightLight

@Suppress("TopLevelPropertyNaming")
private const val APP_LOGO_FRACTION_WIDTH = 0.75F

/**
 * This composable maintains the entire screen for handling user input.
 *
 * @param [viewState] The current state of Login screen to render.
 */
@Composable
fun LoginContent(
    viewState: LoginViewState,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Box(
            modifier = Modifier
                // bottom padding to be added in case of [bottomBar] used
                .padding(it),
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
                Spacer(
                    modifier = Modifier
                        .weight(1F),
                )
                TOATextField(
                    text = viewState.userName,
                    onTextChanged = { /* TODO */ },
                    labelText = stringResource(
                        R.string.username,
                    ),
                )
                TOATextField(
                    text = viewState.password,
                    onTextChanged = { /* TODO */ },
                    labelText = stringResource(
                        R.string.password,
                    ),
                )

                VerticalSpacer(height = 48.dp)

                PrimaryButton(
                    text = stringResource(
                        R.string.sign_in,
                    ),
                    onClick = { /*TODO*/ },
                    backgroundColor = MaterialTheme.colorScheme.primary,
                )

                VerticalSpacer(height = 12.dp)

                SecondaryButton(
                    text = stringResource(
                        R.string.sign_up,
                    ),
                    onClick = { /* TODO */ },
                    contentColor = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@PreviewNightLight
@Composable
private fun EmptyLoginContentPreview() {
    val viewState = LoginViewState(
        userName = "",
        password = "",
    )
    TasksOfAffirmationTheme {
        LoginContent(
            viewState,
        )
    }
}
