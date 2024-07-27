package platform

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import local.TeamEntity
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal actual fun createKStore(): KStore<List<TeamEntity>> {
    return teams()
}

private fun teams(): KStore<List<TeamEntity>> {
    return storeOf(key = "teams", default = emptyList())
}