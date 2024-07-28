import commonMain.TeamsComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import io.github.xxfast.kstore.file.utils.DocumentDirectory
import io.github.xxfast.kstore.utils.ExperimentalKStoreApi
import local.TeamEntity
import me.tatarka.inject.annotations.Component
import okio.Path.Companion.toPath
import platform.Foundation.NSFileManager

@Component
abstract class IosTeamsComponent : TeamsComponent {

    @OptIn(ExperimentalKStoreApi::class)
    override fun teamsKStore(): KStore<List<TeamEntity>> {
        val filesDir: String? = NSFileManager.defaultManager.DocumentDirectory?.relativePath
        requireNotNull(filesDir) { "Document directory not found" }
        return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
    }

}