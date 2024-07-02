package org.ncgroup.formula1kmp.starter.di

import org.koin.dsl.module
import org.ncgroup.formula1kmp.starter.data.local.StarterLocalService
import org.ncgroup.formula1kmp.starter.data.repository.StarterRepositoryImpl
import starter.domain.repository.StarterRepository
import org.ncgroup.formula1kmp.starter.presentation.StarterViewModel


val starterModule = module{
    single { StarterLocalService() }
    single<StarterRepository> { StarterRepositoryImpl(get()) }
    factory { StarterViewModel(get()) }
}