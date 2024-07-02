import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.getAsyncImageLoader
import drivers.di.driversModule
import teams.di.teamsModule
import navigation.root.RootNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import starter.di.starterModule
import theme.AppTheme


@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App() = AppTheme {

    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }

    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                sharedModule,
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
