package platform

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import io.github.xxfast.kstore.file.utils.DocumentDirectory
import io.github.xxfast.kstore.utils.ExperimentalKStoreApi
import local.TeamEntity
import okio.Path.Companion.toPath
import platform.Foundation.NSFileManager

internal actual fun createKStore(): KStore<List<TeamEntity>> {
    return teams()
}

@OptIn(ExperimentalKStoreApi::class)
private fun teams(): KStore<List<TeamEntity>> {
    val filesDir: String? = NSFileManager.defaultManager.DocumentDirectory?.relativePath
    requireNotNull(filesDir) { "Document directory not found" }
    return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
}