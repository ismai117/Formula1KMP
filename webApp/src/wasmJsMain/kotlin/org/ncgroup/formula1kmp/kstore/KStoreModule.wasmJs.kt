package org.ncgroup.formula1kmp.kstore

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import org.koin.core.module.Module
import org.koin.dsl.module
import org.ncgroup.formula1kmp.main.teams.data.local.TeamEntity

actual fun kstoreModule(): Module = module {
    single<KStore<List<DriverEntity>>> {
        storeOf(key = "drivers", default = emptyList())
    }
    single<KStore<List<TeamEntity>>> {
        storeOf(key = "teams", default = emptyList())
    }
}