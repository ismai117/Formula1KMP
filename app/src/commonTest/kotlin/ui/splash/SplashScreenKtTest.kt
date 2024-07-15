import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import ui.splash.SplashScreenContent
import kotlin.test.Test

/**
 * ./gradlew :composeApp:connectedAndroidTest
 * ./gradlew :composeApp:iosSimulatorArm64Test
 * ./gradlew :composeApp:desktopTest
 */

class SplashScreenKtTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testSplashScreenContent() = runComposeUiTest {

        setContent { SplashScreenContent() }

        onNodeWithTag("logo").assertIsDisplayed()

    }

}