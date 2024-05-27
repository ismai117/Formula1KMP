package datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import org.ncgroup.formula1kmp.AndroidApp

actual fun createDatastore(): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        corruptionHandler = null,
        migrations = emptyList(),
        produceFile = { datastore().toPath() }
    )
}

private fun datastore(): String {
    return AndroidApp.INSTANCE.filesDir.resolve(DATASTORE_FILENAME).absolutePath
}