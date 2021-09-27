package com.github.maxfie1d.compose.navigation.sample.ui.screen

sealed class Screen(val route: String) {
    object Start : Screen("/")

    object Dialog : Screen("dialog")

    object BottomSheet : Screen("bottom-sheet")

    object Composable : Screen("composable")

    object Activity : Screen("activity")

    object ActivityWithResult : Screen("activity-with-result")
}
