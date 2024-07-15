package di

import drivers.DriverEntity
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
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

private fun drivers(): KStore<List<DriverEntity>> {
    return storeOf(key = "drivers", default = emptyList())
}

private fun teams(): KStore<List<TeamEntity>> {
    return storeOf(key = "teams", default = emptyList())
}