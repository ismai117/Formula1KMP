import commonMain.DriversComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import io.github.xxfast.kstore.file.utils.FILE_SYSTEM
import local.DriverEntity
import me.tatarka.inject.annotations.Component
import net.harawata.appdirs.AppDirsFactory
import okio.Path.Companion.toPath

private const val PACKAGE_NAME = "org.ncgroup.formula1kmp"
private const val VERSION = "1.0.0"
private const val AUTHOR = "ismailmohamed"

@Component
abstract class DesktopDriversComponent : DriversComponent{

    override fun driversKStore(): KStore<List<DriverEntity>> {
        val filesDir: String = AppDirsFactory.getInstance()
            .getUserDataDir(PACKAGE_NAME, VERSION, AUTHOR)
        FILE_SYSTEM.createDirectories(filesDir.toPath())
        return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
    }

}