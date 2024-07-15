package di

import org.koin.dsl.module
import starter.StarterLocalService

val storageModule = module {
    single { StarterLocalService() }
}