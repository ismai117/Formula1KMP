package datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

expect fun createDatastore(): DataStore<Preferences>

const val DATASTORE_FILENAME = "formula1.preferences_pb"