package commonMain

import local.StarterLocalService
import me.tatarka.inject.annotations.Provides
import starter.StarterRepository
import starter.StarterRepositoryImpl
import ui.StarterScreen
import ui.StarterViewModel

interface StarterComponent {

    val starterScreen: StarterScreen
    val starterViewModel: StarterViewModel

    @Provides
    fun provideStarterLocalService(): StarterLocalService = StarterLocalService()
    @Provides
    fun provideStarterRepository(
        local: StarterLocalService,
    ): StarterRepository = StarterRepositoryImpl(local)

}