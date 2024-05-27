package starter.di

import org.koin.dsl.module
import starter.data.repository.StarterRepositoryImpl
import starter.domain.repository.StarterRepository
import starter.presentation.StarterViewModel


val starterModule = module{
    single<StarterRepository> { StarterRepositoryImpl(get()) }
    factory { StarterViewModel(get()) }
}