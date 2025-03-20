package com.kolu.mediconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolu.mediconnect.presentation.screens.auth.login.LoginScreen
import com.kolu.mediconnect.presentation.screens.auth.register.RegisterScreen
import com.kolu.mediconnect.presentation.screens.home.HomeScreen

@Composable
fun MainNavGraph(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinationScreens.Home,
        modifier = modifier
    ) {
        composable<DestinationScreens.Home> {
            HomeScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(DestinationScreens.Login) {
                        popUpTo(DestinationScreens.Home) { inclusive = true }
                    }
                }
            )
        }
        composable<DestinationScreens.Login> {
            LoginScreen(
                onNavigateToRegisterScreen = {
                    navController.navigate(DestinationScreens.Register)
                }
            )
        }
        composable<DestinationScreens.Register> { RegisterScreen() }
    }
}