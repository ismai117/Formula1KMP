package di

import drivers.DriverEntity
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import io.github.xxfast.kstore.file.utils.FILE_SYSTEM
import net.harawata.appdirs.AppDirsFactory
import okio.Path.Companion.toPath
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import teams.TeamEntity


actual fun platformModule(): Module = module {
    single<KStore<List<DriverEntity>>>(named("drivers_kstore")) {
        drivers()
    }
    single<KStore<List<TeamEntity>>>(named("teams_kstore")) {
        teams()
    }
}

private const val PACKAGE_NAME = "org.ncgroup.formula1kmp"
private const val VERSION = "1.0.0"
private const val AUTHOR = "ismailmohamed"

private fun drivers(): KStore<List<DriverEntity>> {
    val filesDir: String = AppDirsFactory.getInstance()
        .getUserDataDir(PACKAGE_NAME, VERSION, AUTHOR)
    FILE_SYSTEM.createDirectories(filesDir.toPath())
    return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
}

private fun teams(): KStore<List<TeamEntity>> {
    val filesDir: String = AppDirsFactory.getInstance()
        .getUserDataDir(PACKAGE_NAME, VERSION, AUTHOR)
    FILE_SYSTEM.createDirectories(filesDir.toPath())
    return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
}