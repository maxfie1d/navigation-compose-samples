package com.github.maxfie1d.compose.navigation.sample.ui.screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.activity
import androidx.navigation.compose.dialog
import androidx.navigation.plusAssign
import com.github.maxfie1d.compose.navigation.sample.SecondActivity
import com.github.maxfie1d.compose.navigation.sample.ThirdActivity
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

@OptIn(
    com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi::class,
    androidx.compose.animation.ExperimentalAnimationApi::class
)
@Composable
fun MainScreen(
    makeToast: (String) -> Unit,
) {
    val navController = rememberAnimatedNavController()
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    val thirdActivityLauncher =
        rememberLauncherForActivityResult(contract = ThirdActivity.Contract()) { result ->
            makeToast(result.toString())
        }

    ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {
        AnimatedNavHost(
            navController = navController,
            startDestination = Screen.Start.route,
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { 1000 })
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { -1000 })
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { -1000 })
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { 1000 })
            },
        ) {
            composable(Screen.Start.route) {
                StartScreen { screen ->
                    if (screen == Screen.ActivityWithResult) {
                        thirdActivityLauncher.launch(Unit)
                    } else {
                        navController.navigate(screen.route)
                    }
                }
            }

            dialog(Screen.Dialog.route) {
                DialogScreen { result ->
                    makeToast(result.name)
                    navController.popBackStack()
                }
            }

            bottomSheet(route = Screen.BottomSheet.route) {
                BottomSheetScreen { result ->
                    makeToast(result.toString())
                    navController.popBackStack()
                }
            }

            composable(Screen.Composable.route) {
                CountUpScreen(
                    title = "Composable",
                    onResult = { result ->
                        makeToast(result.toString())
                        navController.popBackStack()
                    },
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                )
            }

            activity(Screen.Activity.route) {
                activityClass = SecondActivity::class
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    MainScreen(makeToast = {})
}
