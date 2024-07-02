import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import database.AppDatabase
import database.getAppDatabase
import datastore.createDatastore
import org.koin.dsl.module


val sharedModule = module {
    single<AppDatabase> { getAppDatabase() }
    single<DataStore<Preferences>> { createDatastore() }
}