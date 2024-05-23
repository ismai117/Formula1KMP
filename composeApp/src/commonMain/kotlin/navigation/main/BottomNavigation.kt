package navigation.main


import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState


private sealed class BottomNavigationItem(
    val route: String,
    val label: String,
){
    data object DriversListScreen : BottomNavigationItem(
        route = "drivers_list_screen",
        label = "Drivers",
    )
    data object TeamsListScreen : BottomNavigationItem(
        route = "teams_list_screen",
        label = "Teams",
    )
}

private val screens = listOf(
    BottomNavigationItem.DriversListScreen,
    BottomNavigationItem.TeamsListScreen
)

@Composable
fun BottomNavigation(
    navController: NavController
){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        tonalElevation = 0.dp,
        containerColor = Color.Transparent
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any{ it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route)  {
                        navController.graph.findStartDestination().route?.let {
                            popUpTo(it){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = {
                    Text(
                        text = screen.label,
                        style = TextStyle(
                            color = if (screen.route == currentDestination?.route) Color.White else Color(0xffe80404),
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                icon = {},
                modifier = Modifier
                    .background(
                        color = if (screen.route == currentDestination?.route) Color(0xffe80404) else Color.Transparent,
                        shape = RoundedCornerShape(
                            topStart = if (screen.route == BottomNavigationItem.TeamsListScreen.route) 24.dp else 0.dp,
                            topEnd = if (screen.route == BottomNavigationItem.DriversListScreen.route) 24.dp else 0.dp
                        )
                    )
            )
        }
    }

}