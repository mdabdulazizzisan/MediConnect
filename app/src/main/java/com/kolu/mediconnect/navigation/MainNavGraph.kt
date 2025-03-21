package com.kolu.mediconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolu.mediconnect.presentation.screens.auth.AuthViewModel
import com.kolu.mediconnect.presentation.screens.auth.login.LoginScreen
import com.kolu.mediconnect.presentation.screens.auth.register.RegisterScreen
import com.kolu.mediconnect.presentation.screens.home.HomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavGraph(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    val authViewModel: AuthViewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = DestinationScreens.Home,
        modifier = modifier
    ) {
        composable<DestinationScreens.Home> {
            HomeScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(DestinationScreens.Login)
                }
            )
        }
        composable<DestinationScreens.Login> {
            LoginScreen(
                authViewModel = authViewModel,
                onNavigateToRegisterScreen = {
                    navController.navigate(DestinationScreens.Register)
                },
                onLoginSuccess = {
                    navController.navigate(DestinationScreens.Home)
                }
            )
        }
        composable<DestinationScreens.Register> { RegisterScreen(
            authViewModel = authViewModel,
            onRegisterSuccess = {navController.navigate(DestinationScreens.Login) }
        ) }
    }
}