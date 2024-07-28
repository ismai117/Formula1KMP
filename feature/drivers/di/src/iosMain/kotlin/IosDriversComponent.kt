import commonMain.DriversComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import io.github.xxfast.kstore.file.utils.DocumentDirectory
import io.github.xxfast.kstore.utils.ExperimentalKStoreApi
import local.DriverEntity
import me.tatarka.inject.annotations.Component
import okio.Path.Companion.toPath
import platform.Foundation.NSFileManager

@Component
abstract class IosDriversComponent : DriversComponent{

    @OptIn(ExperimentalKStoreApi::class)
    override fun driversKStore(): KStore<List<DriverEntity>> {
        val filesDir: String? = NSFileManager.defaultManager.DocumentDirectory?.relativePath
        requireNotNull(filesDir) { "Document directory not found" }
        return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
    }

}