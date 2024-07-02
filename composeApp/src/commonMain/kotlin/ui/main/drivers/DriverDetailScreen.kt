package ui.main.drivers

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import drivers.viewmodel.DriversViewModel
import getPlatform
import main.drivers.domain.model.Driver
import org.koin.compose.koinInject
import ui.sharedComponents.parallaxLayoutModifier

@Composable
fun DriverDetailScreen(
    driverNumber: Int,
    navigateBack: () -> Unit
) {

    val driversViewModel = koinInject<DriversViewModel>()
    val driver by driversViewModel.driver.collectAsState()

    LaunchedEffect(Unit) {
        driversViewModel.getDriverByDriverNumber(driverNumber)
    }

    DriverDetailScreenContent(
        driver = driver,
        driverNumber = driverNumber,
        navigateBack = navigateBack
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverDetailScreenContent(
    modifier: Modifier = Modifier,
    driver: Driver?,
    driverNumber: Int,
    navigateBack: () -> Unit
) {

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
        contentColor = Color.Black,
        modifier = modifier.padding(
            top = if (getPlatform().name == "desktop" || getPlatform().name == "web") 24.dp else 0.dp
        )
    ) { paddingValues ->

        if (getPlatform().name != "desktop" && getPlatform().name != "web"){

            Mobile(
                driver = driver,
                driverNumber = driverNumber,
                paddingValues = paddingValues
            )

        }else {

            NonMobile(
                driver = driver,
                driverNumber = driverNumber,
                paddingValues = paddingValues
            )

        }

    }

}

@Composable
fun Mobile(
    modifier: Modifier = Modifier,
    driver: Driver?,
    driverNumber: Int,
    paddingValues: PaddingValues
){

    val scrollState = rememberScrollState()

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

            ImageLoader(
                url = driver?.profileImageUrl.orEmpty(),
                description = driver?.fullName.orEmpty(),
                modifier = modifier.fillMaxSize()
            )

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

                    ImageLoader(
                        url = driver?.countryImageUrl.orEmpty(),
                        description = driver?.fullName.orEmpty(),
                        modifier = modifier
                            .size(40.dp)
                    )

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
                        text = driver?.teamName.orEmpty(),
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

                    Text(
                        text = driver?.biography.orEmpty(),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )

                }

            }

        }

    }

}

@Composable
fun NonMobile(
    modifier: Modifier = Modifier,
    driver: Driver?,
    driverNumber: Int,
    paddingValues: PaddingValues
){

    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        Box(
            modifier = modifier
                .weight(0.40f)
                .fillMaxHeight()
        ) {

            ImageLoader(
                url = driver?.profileImageUrl.orEmpty(),
                description = driver?.fullName.orEmpty(),
                modifier = modifier.fillMaxWidth()
            )

        }

        Column(
            modifier = modifier
                .weight(0.60F)
                .fillMaxHeight()
                .background(Color.White)
                .verticalScroll(scrollState)
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

                    ImageLoader(
                        url = driver?.countryImageUrl.orEmpty(),
                        description = driver?.fullName.orEmpty(),
                        modifier = modifier
                            .size(40.dp)
                    )

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
                        text = driver?.teamName.orEmpty(),
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

                    Text(
                        text = driver?.biography.orEmpty(),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )

                }

            }

        }

    }

}


val countryName = mapOf(
    "usa" to "United States of America",
    "tha" to "Thailand",
    "ned" to "Netherlands",
    "mon" to "Monaco",
    "mex" to "Mexico",
    "jpn" to "Japan",
    "ger" to "Germany",
    "gbr" to "United Kingdom",
    "fra" to "France",
    "fin" to "Finland",
    "esp" to "Spain",
    "den" to "Denmark",
    "chn" to "China",
    "can" to "Canada",
    "aus" to "Australia"
)