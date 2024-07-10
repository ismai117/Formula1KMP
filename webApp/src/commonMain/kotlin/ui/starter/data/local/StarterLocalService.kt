package ui.starter.data.local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import getPlatform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class StarterLocalService() {

    private val settings: Settings = Settings()

    fun getStartedState(): Boolean {
        return settings.getBoolean("isStarted", false)
    }

    fun setStartedState() {
        settings.set("isStarted", true)
    }

}