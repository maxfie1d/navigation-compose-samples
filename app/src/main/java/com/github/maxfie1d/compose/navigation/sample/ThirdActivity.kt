package com.github.maxfie1d.compose.navigation.sample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import com.github.maxfie1d.compose.navigation.sample.ui.screen.CountUpScreen

class ThirdActivity : AppCompatActivity() {
    class Contract : ActivityResultContract<Unit, Int>() {
        override fun createIntent(context: Context, input: Unit?): Intent =
            Intent(context, ThirdActivity::class.java)

        override fun parseResult(resultCode: Int, intent: Intent?) = resultCode
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountUpScreen(
                title = "ThirdActivity",
                onResult = {
                    setResult(it)
                    finish()
                },
                onNavigateBack = {
                    setResult(Activity.RESULT_CANCELED)
                    finish()
                },
            )
        }
    }
}
