package navigation

import kotlinx.serialization.Serializable

@Serializable
object SplashScreen
@Serializable
object StarterScreen
@Serializable
object MainGraph

@Serializable
object HorizontalPagerScreen
@Serializable
data class DriverDetailScreen(val driverNumber: Int)
@Serializable
data class TeamDetailScreen(val teamName: String)

