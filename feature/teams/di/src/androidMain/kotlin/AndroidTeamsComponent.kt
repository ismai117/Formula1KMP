import android.content.Context
import commonMain.TeamsComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import local.TeamEntity
import me.tatarka.inject.annotations.Component
import okio.Path.Companion.toPath

@Component
abstract class AndroidTeamsComponent(
    private val ctx: Context
) : TeamsComponent {

    override fun teamsKStore(): KStore<List<TeamEntity>> {
        val filesDir: String = ctx.filesDir.path
        return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
    }

}