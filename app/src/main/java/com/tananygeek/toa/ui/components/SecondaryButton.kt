package com.tananygeek.toa.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.tananygeek.toa.R
import com.tananygeek.toa.ui.theme.ButtonShape
import com.tananygeek.toa.ui.theme.TasksOfAffirmationTheme
import com.tananygeek.toa.ui.utility.PreviewNightLight

/**
 * A custom implementation of a [Button] to show our Branding
 *
 * @param[text] Text inside the button.
 * @param[onClick] A callback invoked whenever button clicked.
 * @param[modifier] An optional [Modifier] to configure the component.
 */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextButton(
        onClick = onClick,
        shape = ButtonShape,
        modifier = modifier
            .height(dimensionResource(id = R.dimen.button_height))
            .fillMaxWidth(),
    ) {
        Text(
            text = text.toUpperCase(Locale.current),

        )
    }
}

@PreviewNightLight
@Composable
fun SecondaryButtonPreview() {
    TasksOfAffirmationTheme {
        Surface {
            SecondaryButton(
                text = "Secondary Button",
                onClick = { },
            )
        }
    }
}
