package main.drivers.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import f1AdditionalData.countryName
import f1AdditionalData.getBiography
import f1AdditionalData.getFlag
import f1AdditionalData.getProfile
import f1AdditionalData.getTeamName
import navigation.main.BottomNavigation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverDetailScreen(
    modifier: Modifier = Modifier,
    driverNumber: Int,
    navigateBack: () -> Unit
) {

    val scrollState = rememberScrollState()

    val driversViewModel = koinInject<DriversViewModel>()
    val driver by driversViewModel.driver.collectAsState()

    LaunchedEffect(Unit) {
        driversViewModel.getDriverByDriverNumber(driverNumber)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navigateBack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = modifier.size(32.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        },
        containerColor = Color.White,
        contentColor = Color.Black
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            Box(
                modifier = modifier
                    .padding(12.dp)
                    .size(380.dp)
                    .align(Alignment.CenterHorizontally)
                    .parallaxLayoutModifier(scrollState, 2)
            ) {

                getProfile(driver?.driverNumber)?.let {
                    Image(
                        painter = painterResource(it),
                        contentDescription = driver?.fullName,
                        contentScale = ContentScale.Fit,
                        modifier = modifier.fillMaxSize()
                    )
                }

            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {

                Column(
                    modifier = modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Row(
                        modifier = modifier
                            .wrapContentSize(),
//                    .border(width = 1.dp , color = Color.Black),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "$driverNumber",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Medium
                            ),
//                    modifier = modifier.border(width = 1.dp , color = Color.Black)
                        )

                        Spacer(
                            modifier = modifier.padding(8.dp)
                        )

                        getFlag(driver?.countryCode?.lowercase())?.let {
                            Image(
                                painter = painterResource(it),
                                contentDescription = driver?.fullName,
                                contentScale = ContentScale.Fit,
                                modifier = modifier
                                    .size(40.dp)
//                            .border(width = 1.dp , color = Color.Black)
                            )
                        }
                    }

                    Text(
                        text = "${driver?.fullName}",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                HorizontalDivider(
                    modifier = modifier.fillMaxWidth()
                )

                Column(
                    modifier = modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = "Team",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = getTeamName(driver?.teamName.orEmpty()),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = "Country",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = countryName[driver?.countryCode?.lowercase()].orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {

                        Text(
                            text = "Biography",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        getBiography(driver?.driverNumber)?.let {
                            Text(
                                text = stringResource(it),
                                style = TextStyle(
                                    fontSize = 16.sp
                                )
                            )
                        }

                    }

                }

            }

        }

    }

}

fun Modifier.parallaxLayoutModifier(scrollState: ScrollState, rate: Int) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val height = if (rate > 0) scrollState.value / rate else scrollState.value
        layout(placeable.width, placeable.height) {
            placeable.place(0, height)
        }
    }


