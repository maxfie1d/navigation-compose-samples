package com.github.maxfie1d.compose.navigation.sample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountUpScreen(
    title: String,
    onResult: (Int) -> Unit,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title)
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "")
                    }
                },
            )
        }
    ) { innerPadding ->
        var count by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = count.toString())
            Button(onClick = { count++ }) {
                Text(text = "Increment")
            }
            Button(
                onClick = { onResult(count) },
                enabled = count > 0,
            ) {
                Text(text = "Confirm")
            }
        }
    }
}

@Preview
@Composable
fun PreviewComposableScreen() {
    CountUpScreen(
        title = "タイトル",
        onResult = {},
        onNavigateBack = {},
    )
}
