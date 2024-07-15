package di

import android.content.Context

import drivers.DriverEntity
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import okio.Path.Companion.toPath
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import teams.TeamEntity

actual fun platformModule(): Module = module {
    single<KStore<List<DriverEntity>>>(named("drivers_kstore")) {
        drivers(get())
    }
    single<KStore<List<TeamEntity>>>(named("teams_kstore")) {
        teams(get())
    }
}

private fun drivers(ctx: Context): KStore<List<DriverEntity>> {
    val filesDir: String = ctx.filesDir.path
    return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
}

private fun teams(ctx: Context): KStore<List<TeamEntity>> {
    val filesDir: String = ctx.filesDir.path
    return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
}