package starter.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import starter.domain.repository.StarterRepository

class StarterRepositoryImpl(
    private val datastore: DataStore<Preferences>
) : StarterRepository {

    private val isStarted = booleanPreferencesKey("isStarted")

    override fun getStartedState(): Flow<Boolean?> = datastore.data
        .map { preferences ->
            preferences[isStarted]
        }

    override suspend fun setStartedState(value: Boolean) {
        datastore.edit { preferences ->
            preferences[isStarted] = value
        }
    }

}