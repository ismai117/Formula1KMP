package starter.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StarterLocalService(
    private val datastore: DataStore<Preferences>
) {

    private val isStarted = booleanPreferencesKey("isStarted")

    fun getStartedState(): Flow<Boolean?> = datastore.data
        .map { preferences ->
            preferences[isStarted]
        }

    suspend fun setStartedState() {
        datastore.edit { preferences ->
            preferences[isStarted] = true
        }
    }

}