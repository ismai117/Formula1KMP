package navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import main.MainScreen
import splash.SplashScreen
import starter.presentation.StarterScreen

@Composable
fun RootNavigation(
    navController: NavController
){
    NavHost(
        navController  = navController as NavHostController,
        startDestination = SPLASH_SCREEN_ROUTE
    ){
        composable(
            route = SPLASH_SCREEN_ROUTE
        ){
            SplashScreen(
                navigateToMainScreen = {
                    navController.navigate(MAIN_SCREEN_ROUTE)
                },
                navigateToStarterScreen = {
                    navController.navigate(STARTER_SCREEN_ROUTE)
                }
            )
        }
        composable(
            route = STARTER_SCREEN_ROUTE
        ){
            StarterScreen(
                navigateToMainScreen = {
                    navController.navigate(MAIN_SCREEN_ROUTE)
                }
            )
        }
        composable(
            route = MAIN_SCREEN_ROUTE
        ){
            MainScreen()
        }
    }
}