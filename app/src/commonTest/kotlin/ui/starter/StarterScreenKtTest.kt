package ui.starter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import drivers.viewmodel.DriversState
import teams.viewmodel.TeamsState
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * ./gradlew :composeApp:connectedAndroidTest
 * ./gradlew :composeApp:iosSimulatorArm64Test
 * ./gradlew :composeApp:desktopTest
 */

class StarterScreenKtTest {

    // mobile

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testStarterScreenMobileContent() = runComposeUiTest {

        val driversState by mutableStateOf(DriversState())
        val teamsState by mutableStateOf(TeamsState())

        setContent {
            StarterScreenContent(
                platformType = Type.MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = {},
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsNotDisplayed()

        onNodeWithTag("bgImage").assertIsDisplayed()
        onNodeWithTag("logo").assertIsDisplayed()
        onNodeWithTag("year").assertIsDisplayed()
        onNodeWithTag("year").assertTextEquals("2024")

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDataIsLoadingMobileContent() = runComposeUiTest {

        var driversState by mutableStateOf(DriversState())
        var teamsState by mutableStateOf(TeamsState())

        setContent {
            StarterScreenContent(
                platformType = Type.MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = {
                    driversState = driversState.copy(isLoading = true)
                    teamsState = teamsState.copy(isLoading = true)
                },
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsNotDisplayed()

        onNodeWithTag("loading_text").assertIsNotDisplayed()
        onNodeWithTag("loading_indicator").assertIsNotDisplayed()

        onNodeWithTag("getStarted_btn").assertIsDisplayed()
        onNodeWithTag("getStarted_btn").performClick()

        onNodeWithTag("loading_text").assertIsDisplayed()
        onNodeWithTag("loading_text").assertTextEquals("Data Loading...")
        onNodeWithTag("loading_indicator").assertIsDisplayed()

        onNodeWithTag("getStarted_btn").assertIsNotDisplayed()

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDataNotLoadingMobileContent() = runComposeUiTest {

        val driversState by mutableStateOf(DriversState())
        val teamsState by mutableStateOf(TeamsState())

        var buttonClicked = false

        setContent {
            StarterScreenContent(
                platformType = Type.MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = { buttonClicked = true },
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsNotDisplayed()

        onNodeWithTag("loading_text").assertIsNotDisplayed()
        onNodeWithTag("loading_indicator").assertIsNotDisplayed()

        onNodeWithTag("getStarted_btn").assertIsDisplayed()
        onNodeWithTag("getStarted_btn").assertTextEquals("Get Started")
        onNodeWithTag("getStarted_btn").performClick()

        assertEquals(true, buttonClicked)

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testSnackBarMobileErrorMessage() = runComposeUiTest {

        var driversState by mutableStateOf(DriversState())
        var teamsState by mutableStateOf(TeamsState())

        val error = "Unable to resolve host 'f1api-67q1.onrender.com': No address associated with hostname"

        setContent {
            StarterScreenContent(
                platformType = Type.MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = {
                     driversState = driversState.copy(message = error)
                     teamsState = teamsState.copy(message = error)
                },
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsNotDisplayed()

        onNodeWithTag("getStarted_btn").assertIsDisplayed()
        onNodeWithTag("getStarted_btn").assertTextEquals("Get Started")
        onNodeWithTag("getStarted_btn").performClick()

        onNodeWithTag("snackBar").assertIsDisplayed()
        onNodeWithTag("snackBar_text").assertTextContains(error)

    }

    // non mobile

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testStarterScreenNonMobileContent() = runComposeUiTest {

        val driversState by mutableStateOf(DriversState())
        val teamsState by mutableStateOf(TeamsState())

        setContent {
            StarterScreenContent(
                platformType = Type.NON_MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = {},
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsNotDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsDisplayed()

        onNodeWithTag("bgImage").assertIsDisplayed()
        onNodeWithTag("logo").assertIsDisplayed()
        onNodeWithTag("year").assertIsDisplayed()
        onNodeWithTag("year").assertTextEquals("2024")

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDataIsLoadingNonMobileContent() = runComposeUiTest {

        var driversState by mutableStateOf(DriversState())
        var teamsState by mutableStateOf(TeamsState())

        setContent {
            StarterScreenContent(
                platformType = Type.NON_MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = {
                    driversState = driversState.copy(isLoading = true)
                    teamsState = teamsState.copy(isLoading = true)
                },
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsNotDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsDisplayed()

        onNodeWithTag("loading_text").assertIsNotDisplayed()
        onNodeWithTag("loading_indicator").assertIsNotDisplayed()

        onNodeWithTag("getStarted_btn").assertIsDisplayed()
        onNodeWithTag("getStarted_btn").performClick()

        onNodeWithTag("loading_text").assertIsDisplayed()
        onNodeWithTag("loading_text").assertTextEquals("Data Loading...")
        onNodeWithTag("loading_indicator").assertIsDisplayed()

        onNodeWithTag("getStarted_btn").assertIsNotDisplayed()

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDataNotLoadingNonMobileContent() = runComposeUiTest {

        val driversState by mutableStateOf(DriversState())
        val teamsState by mutableStateOf(TeamsState())

        var buttonClicked = false

        setContent {
            StarterScreenContent(
                platformType = Type.NON_MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = { buttonClicked = true },
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsNotDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsDisplayed()

        onNodeWithTag("loading_text").assertIsNotDisplayed()
        onNodeWithTag("loading_indicator").assertIsNotDisplayed()

        onNodeWithTag("getStarted_btn").assertIsDisplayed()
        onNodeWithTag("getStarted_btn").assertTextEquals("Get Started")
        onNodeWithTag("getStarted_btn").performClick()

        assertEquals(true, buttonClicked)

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testSnackBarNonMobileErrorMessage() = runComposeUiTest {

        var driversState by mutableStateOf(DriversState())
        var teamsState by mutableStateOf(TeamsState())

        val error = "Unable to resolve host 'f1api-67q1.onrender.com': No address associated with hostname"

        setContent {
            StarterScreenContent(
                platformType = Type.NON_MOBILE,
                driversState = driversState,
                teamsState = teamsState,
                getStarted = {
                    driversState = driversState.copy(message = error)
                    teamsState = teamsState.copy(message = error)
                },
                navigateToMainScreen = {}
            )
        }

        onNodeWithTag("mobile_layout").assertIsNotDisplayed()
        onNodeWithTag("nonMobile_layout").assertIsDisplayed()

        onNodeWithTag("getStarted_btn").assertIsDisplayed()
        onNodeWithTag("getStarted_btn").assertTextEquals("Get Started")
        onNodeWithTag("getStarted_btn").performClick()

        onNodeWithTag("snackBar").assertIsDisplayed()
        onNodeWithTag("snackBar_text").assertTextContains(error)

    }

}