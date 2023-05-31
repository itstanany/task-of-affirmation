package com.tananygeek.toa.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
 * @param[backgroundColor] Optional background color in enabled state.
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
) {
    val buttonColors = buttonColors(
        containerColor = backgroundColor,
    )
    Button(
        onClick = onClick,
        colors = buttonColors,
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
fun PrimaryButtonPreview() {
    TasksOfAffirmationTheme() {
        PrimaryButton(
            text = "Primary Button",
            onClick = { },
        )
    }
}
