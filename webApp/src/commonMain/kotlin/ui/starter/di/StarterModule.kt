package ui.starter.di

import org.koin.dsl.module
import ui.starter.data.local.StarterLocalService
import starter.data.repository.StarterRepositoryImpl
import ui.starter.domain.repository.StarterRepository
import starter.viewmodel.StarterViewModel

val starterModule = module{
    single { StarterLocalService() }
    single<StarterRepository> { StarterRepositoryImpl(get()) }
    factory { StarterViewModel(get()) }
}