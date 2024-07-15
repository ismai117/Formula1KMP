package di

import drivers.DriverEntity
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import io.github.xxfast.kstore.file.utils.DocumentDirectory
import io.github.xxfast.kstore.utils.ExperimentalKStoreApi
import okio.Path.Companion.toPath
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import platform.Foundation.NSFileManager
import teams.TeamEntity

actual fun platformModule(): Module = module {
    single<KStore<List<DriverEntity>>>(named("drivers_kstore")) {
        drivers()
    }
    single<KStore<List<TeamEntity>>>(named("teams_kstore")) {
        teams()
    }
}

@OptIn(ExperimentalKStoreApi::class)
private fun drivers(): KStore<List<DriverEntity>> {
    val filesDir: String? = NSFileManager.defaultManager.DocumentDirectory?.relativePath
    requireNotNull(filesDir) { "Document directory not found" }
    return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
}

@OptIn(ExperimentalKStoreApi::class)
private fun teams(): KStore<List<TeamEntity>> {
    val filesDir: String? = NSFileManager.defaultManager.DocumentDirectory?.relativePath
    requireNotNull(filesDir) { "Document directory not found" }
    return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
}