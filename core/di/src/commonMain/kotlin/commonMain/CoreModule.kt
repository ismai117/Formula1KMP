package commonMain

import di.databaseModule
import di.networkModule
import di.storageModule
import org.koin.dsl.module

val coreModule = module {
    includes(
        databaseModule,
        networkModule,
        storageModule
    )
}