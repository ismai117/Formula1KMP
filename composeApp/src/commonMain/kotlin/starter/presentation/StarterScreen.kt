package starter.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import formula1kmp.composeapp.generated.resources.Res
import formula1kmp.composeapp.generated.resources.bg
import formula1kmp.composeapp.generated.resources.logo
import main.drivers.presentation.DriversState
import main.drivers.presentation.DriversViewModel
import main.teams.presentation.TeamsState
import main.teams.presentation.TeamsViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun StarterScreen(
    navigateToMainScreen: () -> Unit
){

    val starterViewModel = koinInject<StarterViewModel>()

    val driversViewModel = koinInject<DriversViewModel>()
    val driversState by driversViewModel.state.collectAsState()

    val teamsViewModel = koinInject<TeamsViewModel>()
    val teamsState by teamsViewModel.state.collectAsState()

    StarterScreenContent(
        driversState = driversState,
        teamsState = teamsState,
        onEvent = starterViewModel::onEvent,
        navigateToMainScreen = navigateToMainScreen,
        getStarted = {
            driversViewModel.getDrivers()
            teamsViewModel.getTeams()
        }
    )

}

@Composable
fun StarterScreenContent(
    modifier: Modifier = Modifier,
    driversState: DriversState,
    teamsState: TeamsState,
    onEvent: (StarterOnEvent) -> Unit,
    navigateToMainScreen: () -> Unit,
    getStarted: () -> Unit
){

    val hostState = remember { SnackbarHostState() }

    LaunchedEffect(driversState.success, teamsState.success){
        if (driversState.success && teamsState.success) {
            onEvent(StarterOnEvent.STARTED)
            navigateToMainScreen()
        }
    }

    LaunchedEffect(driversState.error, teamsState.error){
        if (driversState.error.isNotBlank() || teamsState.error.isNotBlank()) {
            hostState.showSnackbar(driversState.error)
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = hostState
            ){ data ->
                Snackbar(
                    snackbarData = data
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier = modifier
                .fillMaxSize()
        ){

            Image(
                painter = painterResource(Res.drawable.bg),
                contentDescription = "",
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = modifier
                    .padding(top = 100.dp)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = null,
                    modifier = modifier
                        .width(160.dp)
                        .height(40.dp)
                )
                Text(
                    text = "2024",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }

            if (driversState.loading && teamsState.loading) {
                Box(
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 40.dp)
                        .fillMaxWidth()
                        .height(55.dp)
                        .align(Alignment.BottomCenter)
                        .background(Color(0xffe80404)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Data Loading...",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        ),
                        modifier = modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterStart)
                    )
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = modifier
                            .padding(end  = 16.dp)
                            .size(24.dp)
                            .align(Alignment.CenterEnd)
                    )
                }
            } else {
                Box(
                    modifier = modifier
                        .padding(start = 24.dp, end = 24.dp, bottom = 140.dp)
                        .align(Alignment.BottomCenter),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            getStarted()
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffe80404)
                        )
                    ){
                        Text(
                            text = "Get Started",
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                    }
                }
            }

        }

    }

}