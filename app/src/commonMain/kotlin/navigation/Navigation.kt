package navigation

import AppComponent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import ui.main.horizontalPager.HorizontalPagerScreen
import ui.splash.SplashScreen

@Composable
fun Navigation(
    appComponent: AppComponent,
    navController: NavController
){
    NavHost(
        navController  = navController as NavHostController,
        startDestination = SplashScreen
    ){
        composable(route = SplashScreen){
            SplashScreen(
                navigateToMainScreen = {
                    navController.navigate(MainGraph)
                },
                navigateToStarterScreen = {
                    navController.navigate(StarterScreen)
                }
            )
        }
        composable(route = StarterScreen){
            appComponent.starterComponent.starterScreen {
                navController.navigate(MainGraph)
            }
        }
        mainGraph(
            appComponent = appComponent,
            navController = navController
        )
    }
}

fun NavGraphBuilder.mainGraph(
    appComponent: AppComponent,
    navController: NavController,
) {
    navigation(
        route = MainGraph,
        startDestination = HorizontalPagerScreen
    ){
        composable(route = HorizontalPagerScreen) {
            HorizontalPagerScreen(
                appComponent = appComponent,
                navigateToDriverDetailScreen = { driverNumber ->
                    navController.navigate("$DriverDetailScreen/$driverNumber")
                },
                navigateToTeamDetailScreen = { teamName ->
                    navController.navigate("$TeamDetailScreen/${teamName}")
                }
            )
        }
        composable(
            route = "$DriverDetailScreen/{driverNumber}",
            arguments = listOf(navArgument("driverNumber"){ type = NavType.IntType })
        ){ backStackEntry ->
            backStackEntry.arguments?.getInt("driverNumber")?.let { driverNumber ->
                appComponent.driversComponent.driverDetailScreen(driverNumber){
                    navController.popBackStack()
                }
            }
        }
        composable(
            route = "$TeamDetailScreen/{teamName}",
            arguments = listOf(navArgument("teamName"){ type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("teamName")?.let { teamName ->
                appComponent.teamsComponent.teamDetailScreen(teamName){
                    navController.popBackStack()
                }
            }
        }
    }
}




//@Composable
//fun Navigation(
//    navController: NavController
//){
//    NavHost(
//        navController  = navController as NavHostController,
//        startDestination = SplashScreen
//    ){
//        composable<SplashScreen>{
//            SplashScreen(
//                navigateToMainScreen = {
//                    navController.navigate(MainGraph)
//                },
//                navigateToStarterScreen = {
//                    navController.navigate(StarterScreen)
//                }
//            )
//        }
//        composable<StarterScreen>{
//            StarterScreen(
//                navigateToMainScreen = {
//                    navController.navigate(MainGraph)
//                }
//            )
//        }
//        mainGraph(navController)
//    }
//}
//
//fun NavGraphBuilder.mainGraph(
//    navController: NavController,
//) {
//    navigation<MainGraph>(
//        startDestination = HorizontalPagerScreen
//    ){
//        composable<HorizontalPagerScreen> {
//            HorizontalPagerScreen(
//                navigateToDriverDetailScreen = { driverNumber ->
//                    navController.navigate(DriverDetailScreen(driverNumber))
//                },
//                navigateToTeamDetailScreen = { teamName ->
//                    navController.navigate(TeamDetailScreen(teamName))
//                }
//            )
//        }
//        composable<DriverDetailScreen> {
//            val args = it.toRoute<DriverDetailScreen>()
//            DriverDetailScreen(
//                driverNumber = args.driverNumber,
//                navigateBack = {
//                    navController.popBackStack()
//                }
//            )
//        }
//        composable<TeamDetailScreen> {
//            val args = it.toRoute<TeamDetailScreen>()
//            TeamDetailScreen(
//                teamName = args.teamName,
//                navigateBack = {
//                    navController.popBackStack()
//                }
//            )
//        }
//    }
//}
//
//
