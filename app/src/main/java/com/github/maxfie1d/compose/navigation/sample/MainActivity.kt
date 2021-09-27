package com.github.maxfie1d.compose.navigation.sample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.maxfie1d.compose.navigation.sample.ui.screen.MainScreen
import com.github.maxfie1d.compose.navigation.sample.ui.theme.ComposenavigationsamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposenavigationsamplesTheme {
                MainScreen {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
