package main.drivers.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.github.ajalt.colormath.extensions.android.composecolor.toComposeColor
import com.github.ajalt.colormath.parse
import getPlatform
import main.drivers.domain.model.Driver
import navigation.main.BottomNavigation
import org.koin.compose.koinInject

@Composable
fun DriversListScreen(
    navController: NavController,
    navigateToDriverDetailScreen: (Int) -> Unit
) {

    val driversViewModel = koinInject<DriversViewModel>()
    val state by driversViewModel.state.collectAsState()

    LaunchedEffect(Unit){
        driversViewModel.getDrivers()
    }

    DriversListScreenContent(
        navController = navController,
        state = state,
        navigateToDriverDetailScreen = navigateToDriverDetailScreen
    )

}

@Composable
fun DriversListScreenContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    state: DriversState,
    navigateToDriverDetailScreen: (Int) -> Unit
) {

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = Color.Black
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            Box(
                modifier = modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
            ){

                Text(
                    text = "Drivers",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = modifier
                        .padding(start = 24.dp)
                        .align(Alignment.CenterStart)
                )

                Text(
                    text = "2024",
                    style = TextStyle(
                        color = Color(0xffe80404),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = modifier
                        .padding(end = 24.dp)
                        .align(Alignment.CenterEnd)
                )

            }


            LazyVerticalGrid(
                columns = GridCells.Adaptive(324.dp),
                modifier = modifier
                    .padding(top = 12.dp),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement =  Arrangement.spacedBy(16.dp)
            ){

                items(
                    items = state.drivers,
                    key = { driver -> driver.driverNumber.hashCode() }
                ) { item ->

                    DriverItem(
                        driver = item,
                        onClick = { driverNumber ->
                            navigateToDriverDetailScreen(driverNumber)
                        }
                    )

                }

            }

        }

    }

}


@Composable
fun DriverItem(
    modifier: Modifier = Modifier,
    driver: Driver,
    onClick: (Int) -> Unit
) {

    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .height(if (getPlatform().name == "desktop") 252.dp else 240.dp)
            .clickable {
                onClick(driver.driverNumber)
            },
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Transparent
        )
    ) {

        Row(
            modifier = modifier.fillMaxSize()
        ) {

            Box(
                modifier = modifier
                    .weight(0.60f)
                    .fillMaxHeight(),
//                    .border(width = 1.dp, color = Color.White),
                contentAlignment = Alignment.CenterStart
            ) {

                Column(
                    modifier = modifier
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    AsyncImage(
                        model = driver.driverNumberImage,
                        contentDescription = driver.fullName,
                        contentScale = ContentScale.Fit,
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        VerticalDivider(
                            modifier = modifier
                                .height(45.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            thickness = 4.dp,
                            color = com.github.ajalt.colormath.Color.parse("#${driver.teamColour}").toComposeColor()
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = driver.firstName,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = driver.lastName,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }

                    Text(
                        text = driver.teamName
                    )

                }

            }

            Column(
                modifier = modifier
                    .weight(0.40f)
                    .fillMaxHeight()
            ) {

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f),
//                        .border(width = 1.dp, color = Color.White),
                    contentAlignment = Alignment.Center
                ) {

                    AsyncImage(
                        model = driver.countryImageUrl,
                        contentDescription = driver.fullName,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .padding(top = 16.dp)
                            .size(40.dp)
                    )

                }

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentAlignment = Alignment.Center
                ) {

                    AsyncImage(
                        model = driver.headshotImageUrl,
                        contentDescription = driver.fullName,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .padding(end = 16.dp)
                            .size(160.dp)
                    )

                }

            }

        }

    }

}

