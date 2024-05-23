package splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import formula1kmp.composeapp.generated.resources.Res
import formula1kmp.composeapp.generated.resources.logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToMainScreen: () -> Unit
) {

    LaunchedEffect(Unit) {
        delay(1500)
        navigateToMainScreen()
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = null,
            modifier = modifier
                .width(160.dp)
                .height(40.dp)
        )

    }

}