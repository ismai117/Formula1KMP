package starter

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class StarterLocalService() {

    private val settings: Settings = Settings()

    fun getStartedState(): Boolean {
        return settings.getBoolean("isStarted", false)
    }

    fun setStartedState() {
        settings.set("isStarted", true)
    }

}