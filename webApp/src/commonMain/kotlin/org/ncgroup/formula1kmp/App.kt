package org.ncgroup.formula1kmp

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import io.ktor.client.utils.clientDispatcher
import io.ktor.utils.io.InternalAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import navigation.root.RootNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.module
import org.ncgroup.formula1kmp.database.DatabaseDriverFactory
import org.ncgroup.formula1kmp.db.AppDatabase
import org.ncgroup.formula1kmp.main.drivers.di.driversModule
import org.ncgroup.formula1kmp.main.teams.di.teamsModule
import org.ncgroup.formula1kmp.starter.di.starterModule

@Composable
@Preview
internal fun App() = MaterialTheme {

    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                module {
                   single<AppDatabase> {
                      AppDatabase(DatabaseDriverFactory())
                   }
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


internal expect fun openUrl(url: String?)

@OptIn(InternalAPI::class)
fun io(): CoroutineDispatcher {
    return Dispatchers.clientDispatcher(200, "IO")
}