package com.github.maxfie1d.compose.navigation.sample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.maxfie1d.compose.navigation.sample.R

@Composable
fun StartScreen(
    navigate: (Screen) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { navigate(Screen.Dialog) }) {
                Text("Dialog")
            }
            Button(onClick = { navigate(Screen.BottomSheet) }) {
                Text("BottomSheet")
            }
            Button(onClick = { navigate(Screen.Composable) }) {
                Text("Composable")
            }
            Button(onClick = { navigate(Screen.Activity) }) {
                Text(text = "Activity")
            }
            Button(onClick = { navigate(Screen.ActivityWithResult) }) {
                Text(text = "Activity with result")
            }
        }
    }
}

@Preview
@Composable
private fun PreviewStartScreen() {
    StartScreen(navigate = {})
}
