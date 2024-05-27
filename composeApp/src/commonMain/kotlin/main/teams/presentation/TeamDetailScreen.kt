package main.teams.presentation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import coil3.compose.AsyncImage
import main.teams.domain.model.Team
import org.koin.compose.koinInject

@Composable
fun TeamDetailScreen(
    teamName: String,
    navigateBack: () -> Unit
) {

    val teamsViewModel = koinInject<TeamsViewModel>()
    val team by teamsViewModel.team.collectAsState()

    LaunchedEffect(Unit) {
        teamsViewModel.getTeamByTeamName(teamName)
    }

    TeamDetailScreenContent(
        team = team,
        navigateBack = navigateBack
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreenContent(
    modifier: Modifier = Modifier,
    team: Team?,
    navigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = team?.name.orEmpty(),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                },
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
                actions = {
                    AsyncImage(
                        model = team?.logoUrl,
                        contentDescription = team?.name,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .padding(end = 16.dp)
                            .size(33.dp)
                    )
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

        LazyVerticalStaggeredGrid(
            modifier = modifier.padding(paddingValues),
            columns = StaggeredGridCells.Fixed(2)
        ) {

            items(
                items = team?.drivers.orEmpty()
            ) { driver ->

                Column(
                    modifier = modifier
                        .height(340.dp)
//                    .border(width = 1.dp, color = Color.Black)
                ) {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .weight(0.70f)
//                        .border(width = 1.dp, color = Color.Black)
                    ) {

                        AsyncImage(
                            model = driver.profileImageUrl,
                            contentDescription = driver.fullName,
                            contentScale = ContentScale.Fit,
                            modifier = modifier.fillMaxSize()
                        )

                    }
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .weight(0.30f)
                    ) {

                        Column(
                            modifier = modifier
                                .padding(start = 12.dp)
                                .align(Alignment.CenterStart),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Text(
                                text = "${driver.driverNumber}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )

                            Text(
                                text = driver.fullName,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )

                        }

                    }
                    HorizontalDivider(
                        modifier = modifier.fillMaxWidth()
                    )
                }

            }

            item(
                span = StaggeredGridItemSpan.FullLine
            ) {

                Column(
                    modifier = modifier
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 40.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Full Team Name",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = team?.fullName.orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Base",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = team?.base.orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Team Chief",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = team?.teamChief.orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Technical Chief",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = team?.technicalChief.orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Chassis",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = team?.chassis.orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Power Unit",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "${team?.powerUnit}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }


                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "First Team Entry",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "${team?.firstTeamEntry}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "World Championships",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "${team?.worldChampionships}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Highest Race Finish",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = team?.highestRaceFinish.orEmpty(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Pole Positions",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "${team?.polePositions}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )

                    }

                    Column(
                        modifier = modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Fastest Laps",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "${team?.fastestLaps}",
                            textAlign = TextAlign.Center,
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

fun Modifier.parallaxLayoutModifier(scrollState: ScrollState, rate: Int) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val height = if (rate > 0) scrollState.value / rate else scrollState.value
        layout(placeable.width, placeable.height) {
            placeable.place(0, height)
        }
    }


