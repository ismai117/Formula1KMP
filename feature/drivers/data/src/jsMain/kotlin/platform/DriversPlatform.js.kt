package platform

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import local.DriverEntity

internal actual fun createKStore(): KStore<List<DriverEntity>> {
    return drivers()
}

private fun drivers(): KStore<List<DriverEntity>> {
    return storeOf(key = "drivers", default = emptyList())
}