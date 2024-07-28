package commonMain

import drivers.DriversRepository
import repository.DriversRepositoryImpl
import io.github.xxfast.kstore.KStore
import local.DriverEntity
import local.DriversLocalService
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import remote.DriversRemoteService
import ui.DriverDetailScreen
import ui.DriversListScreen
import ui.DriversViewModel

interface DriversComponent {

    val driversListScreen: DriversListScreen
    val driverDetailScreen: DriverDetailScreen
    val driversViewModel: DriversViewModel

    @Provides
    fun driversKStore(): KStore<List<DriverEntity>>

    @Provides
    fun provideDriversRemoteService(): DriversRemoteService = DriversRemoteService()

    @Provides
    fun provideDriversLocalService(
        kStore: KStore<List<DriverEntity>>,
    ): DriversLocalService = DriversLocalService(kStore)

    @Provides
    fun provideDriversRepository(
        remote: DriversRemoteService,
        local: DriversLocalService,
    ): DriversRepository = DriversRepositoryImpl(remote, local)

}