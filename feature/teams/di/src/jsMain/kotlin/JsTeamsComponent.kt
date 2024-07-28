import commonMain.TeamsComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import local.TeamEntity
import me.tatarka.inject.annotations.Component

@Component
abstract class JsTeamsComponent : TeamsComponent {

    override fun teamsKStore(): KStore<List<TeamEntity>> {
        return storeOf(key = "teams", default = emptyList())
    }

}