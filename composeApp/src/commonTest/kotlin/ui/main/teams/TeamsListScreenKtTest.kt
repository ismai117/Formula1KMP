import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import teams.viewmodel.TeamsState
import ui.main.teams.TeamsListScreenContent
import kotlin.test.Test

/**
 * ./gradlew :composeApp:connectedAndroidTest
 * ./gradlew :composeApp:iosSimulatorArm64Test
 * ./gradlew :composeApp:desktopTest
 */

class TeamsListScreenKtTest {

    @ExperimentalTestApi
    @Test
    fun testTeamsListScreenContent() = runComposeUiTest {

        val teamsState by mutableStateOf(TeamsState())

        setContent {
            TeamsListScreenContent(
                state = teamsState,
                navigateToTeamDetailScreen = {}
            )
        }

    }

}