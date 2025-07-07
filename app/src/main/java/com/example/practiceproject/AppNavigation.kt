package com.example.practiceproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("screen1") { SignInEmail(
            onContinueClick = { navController.navigate("screen2") },
            onCreateAccountClick = { navController.navigate("screen3") }
        ) }
        composable("screen2") { SignInPassword(
            onContinueClick = { navController.navigate("screen6") },
            onResetClick = { navController.navigate("screen4")}
        ) }
        composable("screen3") { CreateAccount(
            onContinueClick = { navController.navigate("screen6") },
            onBackClick = {navController.navigate("screen1")},
            onResetClick = { navController.navigate("screen4")}
        ) }
        composable("screen4") { ForgetPassword(
            onBackClick = {navController.navigate("screen3")},
            onContinueClick = { navController.navigate("screen5") }
        ) }
        composable("screen5") { EmailToReset(navController) }
        composable("screen6") { TellUsPage(navController) }
    }
}