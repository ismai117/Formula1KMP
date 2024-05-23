package database

import org.koin.dsl.module


val appDatabaseModule = module {
    single<AppDatabase> { getAppDatabase() }
}

