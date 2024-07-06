package starter.di

import org.koin.dsl.module
import starter.data.local.StarterLocalService
import starter.data.repository.StarterRepositoryImpl
import starter.domain.repository.StarterRepository
import starter.viewmodel.StarterViewModel

val starterModule = module{
    single { StarterLocalService(get()) }
    single<StarterRepository> { StarterRepositoryImpl(get()) }
    factory { StarterViewModel(get()) }
}