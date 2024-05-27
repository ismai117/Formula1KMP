import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.compose.rememberNavController
import database.AppDatabase
import database.getAppDatabase
import datastore.createDatastore
import main.drivers.di.driversModule
import main.teams.di.teamsModule
import navigation.root.RootNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.module
import starter.di.starterModule
import theme.AppTheme


@Composable
@Preview
fun App() = AppTheme {

    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                module {
                    single<AppDatabase> { getAppDatabase() }
                    single<DataStore<Preferences>> { createDatastore() }
                },
                driversModule,
                teamsModule,
                starterModule
            )
        }
    ) {
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