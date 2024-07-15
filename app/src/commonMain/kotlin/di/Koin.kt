package di

import commonMain.coreModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            coreModule,
            dataModule,
            starterModule,
            driversModule,
            teamsModule
        )
    }

fun initKoin() = initKoin(enableNetworkLogs = false) {}
