import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import coil3.annotation.ExperimentalCoilApi
import coil3.asyncImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.enableDiskCache
import navigation.Navigation
import ui.main.drivers.di.driversModule
import ui.main.teams.di.teamsModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import ui.starter.di.starterModule
import theme.AppTheme


@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App(disableDiskCache: Boolean = false) = AppTheme {

    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                driversModule,
                teamsModule,
                starterModule
            )
        }
    ) {

        setSingletonImageLoaderFactory { context ->
            if (disableDiskCache) context.asyncImageLoader() else
                context.asyncImageLoader().enableDiskCache()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Navigation(
                navController = navController
            )
        }

    }

}
