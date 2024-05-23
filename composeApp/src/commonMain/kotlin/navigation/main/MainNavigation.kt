package navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import main.drivers.presentation.DriverDetailScreen
import main.drivers.presentation.DriversListScreen
import main.teams.presentation.TeamDetailScreen
import main.teams.presentation.TeamsListScreen

@Composable
fun MainNavigation(
    navController: NavController
){

    NavHost(
        navController  = navController as NavHostController,
        startDestination = DRIVERS_LIST_SCREEN_ROUTE
    ){
        composable(
            route = DRIVERS_LIST_SCREEN_ROUTE
        ){
            DriversListScreen(
                navController = navController,
                navigateToDriverDetailScreen = { driverNumber ->
                    navController.navigate(DRIVER_DETAIL_SCREEN_ROUTE + "/${driverNumber}")
                }
            )
        }
        composable(
            route = "$DRIVER_DETAIL_SCREEN_ROUTE/{driverNumber}",
            arguments = listOf(navArgument("driverNumber") { type = NavType.IntType })
        ){backStackEntry ->
            backStackEntry.arguments?.getInt("driverNumber")?.let { driverNumber ->
                DriverDetailScreen(
                    driverNumber = driverNumber,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            route = TEAMS_LIST_SCREEN_ROUTE
        ){
            TeamsListScreen(
                navController = navController,
                navigateToTeamDetailScreen = { teamName ->
                    navController.navigate(TEAM_DETAIL_SCREEN_ROUTE + "/${teamName}")
                }
            )
        }
        composable(
            route = "$TEAM_DETAIL_SCREEN_ROUTE/{teamName}",
            arguments = listOf(navArgument("teamName") { type = NavType.StringType })
        ){backStackEntry ->
            backStackEntry.arguments?.getString("teamName")?.let { teamName->
                TeamDetailScreen(
                    teamName = teamName,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}