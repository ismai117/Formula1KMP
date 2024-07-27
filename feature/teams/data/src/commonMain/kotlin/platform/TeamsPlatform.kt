package platform

import io.github.xxfast.kstore.KStore
import local.TeamEntity

internal expect fun createKStore(): KStore<List<TeamEntity>>

object TeamsPlatformModule {
    val kStore: KStore<List<TeamEntity>> by lazy {
        createKStore()
    }
}