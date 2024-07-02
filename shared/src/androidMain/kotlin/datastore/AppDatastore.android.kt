package datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import applicationContext
import okio.Path.Companion.toPath

actual fun createDatastore(): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        corruptionHandler = null,
        migrations = emptyList(),
        produceFile = { datastore().toPath() }
    )
}

private fun datastore(): String {
    return applicationContext.filesDir.resolve(DATASTORE_FILENAME).absolutePath
}