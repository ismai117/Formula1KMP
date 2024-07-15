package di

import org.koin.dsl.module
import ui.StarterViewModel

val starterModule = module{
    factory { StarterViewModel(get()) }
}