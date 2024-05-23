import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import database.appDatabaseModule
import main.drivers.di.driversModule
import main.teams.di.teamsModule
import navigation.root.RootNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import theme.AppTheme


@Composable
@Preview
fun App() = AppTheme{

    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                appDatabaseModule,
                driversModule,
                teamsModule
            )
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            RootNavigation(
                navController = navController
            )
        }
    }

}