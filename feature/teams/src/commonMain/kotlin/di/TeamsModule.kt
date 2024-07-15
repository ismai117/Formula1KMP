package di

import org.koin.dsl.module
import ui.TeamsViewModel

val teamsModule = module {
    factory { TeamsViewModel(get()) }
}