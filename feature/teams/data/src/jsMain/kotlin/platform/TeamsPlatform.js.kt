package platform

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import local.TeamEntity

internal actual fun createKStore(): KStore<List<TeamEntity>> {
    return teams()
}

private fun teams(): KStore<List<TeamEntity>> {
    return storeOf(key = "teams", default = emptyList())
}