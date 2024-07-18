package local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class StarterLocalService() {

    private val settings: Settings = Settings()

    fun getStartedState(): Boolean {
        return false
    }

    fun setStartedState() {
        settings.set("isStarted", true)
    }

}