package platform

import io.github.xxfast.kstore.KStore
import local.DriverEntity

internal expect fun createKStore(): KStore<List<DriverEntity>>

object DriversPlatformModule {
    val kStore: KStore<List<DriverEntity>> by lazy {
        createKStore()
    }
}
