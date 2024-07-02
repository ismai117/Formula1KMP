package org.ncgroup.formula1kmp.starter.data.local


import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StarterLocalService() {

    private val settings: Settings = Settings()

    fun getStartedState(): Flow<Boolean?> {
        return flowOf(settings.getBooleanOrNull("isStarted"))
    }

    fun setStartedState() {
        settings.putBoolean("isStarted", true)
    }

}