package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import ui.main.drivers.presentation.DriverDetailScreen
import ui.main.horizontalPager.HorizontalPagerScreen
import ui.main.teams.presentation.TeamDetailScreen
import ui.splash.SplashScreen
import ui.starter.StarterScreen

@Composable
fun Navigation(
    navController: NavController
){
    NavHost(
        navController  = navController as NavHostController,
        startDestination = SplashScreen
    ){
        composable<SplashScreen>{
            SplashScreen(
                navigateToMainScreen = {
                    navController.navigate(MainGraph)
                },
                navigateToStarterScreen = {
                    navController.navigate(StarterScreen)
                }
            )
        }
        composable<StarterScreen>{
            StarterScreen(
                navigateToMainScreen = {
                    navController.navigate(MainGraph)
                }
            )
        }
        mainGraph(navController)
    }
}

fun NavGraphBuilder.mainGraph(
    navController: NavController,
) {
    navigation<MainGraph>(
        startDestination = HorizontalPagerScreen
    ){
        composable<HorizontalPagerScreen> {
            HorizontalPagerScreen(
                navigateToDriverDetailScreen = { driverNumber ->
                    navController.navigate(DriverDetailScreen(driverNumber))
                },
                navigateToTeamDetailScreen = { teamName ->
                    navController.navigate(TeamDetailScreen(teamName))
                }
            )
        }
        composable<DriverDetailScreen> {
            val args = it.toRoute<DriverDetailScreen>()
            DriverDetailScreen(
                driverNumber = args.driverNumber,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<TeamDetailScreen> {
            val args = it.toRoute<TeamDetailScreen>()
            TeamDetailScreen(
                teamName = args.teamName,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}


