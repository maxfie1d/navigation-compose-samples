package com.github.maxfie1d.compose.navigation.sample.ui.screen

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.maxfie1d.compose.navigation.sample.DialogAction

@Composable
fun DialogScreen(
    onResult: (DialogAction) -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            onResult(DialogAction.Dismiss)
        },
        title = {
            Text(text = "This is a dialog")
        },
        text = {
            Text("body")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onResult(DialogAction.Positive)
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onResult(DialogAction.Dismiss)
                }
            ) {
                Text("Cancel")
            }
        },
    )
}

@Preview
@Composable
private fun PreviewDialogScreen() {
    DialogScreen(onResult = {})
}
