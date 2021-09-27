package com.github.maxfie1d.compose.navigation.sample.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.maxfie1d.compose.navigation.sample.DialogAction

@Composable
fun BottomSheetScreen(
    onResult: (DialogAction) -> Unit,
) {
    Surface(modifier = Modifier.padding(12.dp, 24.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = "This is a bottom sheet",
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = "body",
                style = MaterialTheme.typography.body1,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                TextButton(
                    onClick = { onResult(DialogAction.Dismiss) },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(text = "Cancel")
                }
                Button(
                    onClick = { onResult(DialogAction.Positive) },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(text = "OK")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetScreen() {
    BottomSheetScreen(onResult = {})
}
