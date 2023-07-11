package com.tananygeek.toa.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tananygeek.toa.R
import com.tananygeek.toa.core.ui.theme.TasksOfAffirmationTheme
import com.tananygeek.toa.core.ui.theme.TextFieldShape
import com.tananygeek.toa.core.ui.utility.PreviewNightLight

/**
 * This is a custom implementation of an [OutlinedTextField] to ensure it reflect
 * our design system and branding.
 *
 * @param[text] The current text presented inside the input.
 * @param[onTextChanged] A callback to be invoked whenever the input changes.
 * @param[labelText] Label the shows above when the component is focused.
 * @param[modifier] An optional [Modifier] to configure the component.
**/
@Composable
fun TOATextField(
    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
    errMsg: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChanged,
            label = {
                Text(text = labelText)
            },
            modifier = modifier
                .heightIn(dimensionResource(id = R.dimen.text_field_height))
                .fillMaxWidth(),
            shape = TextFieldShape,
            isError = (errMsg != null),
            visualTransformation = visualTransformation,
        )

        if (errMsg != null) {
            Text(
                text = errMsg,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        start = 16.dp,
                    ),
            )
        }
    }
}

@PreviewNightLight
@Composable
private fun TOATextFieldPreview() {
    TasksOfAffirmationTheme {
        TOATextField(
            text = "",
            onTextChanged = { },
            labelText = "SOmeLaber",
            errMsg = "Plaaaaaaaaaaa",
        )
    }
}
