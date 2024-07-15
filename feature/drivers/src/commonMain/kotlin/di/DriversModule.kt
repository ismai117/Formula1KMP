package di

import ui.DriversViewModel
import org.koin.dsl.module

val driversModule = module {
    factory { DriversViewModel(get()) }
}