import android.content.Context
import commonMain.DriversComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import local.DriverEntity
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import okio.Path.Companion.toPath

@Component
abstract class AndroidDriversComponent(
    private val ctx: Context,
) : DriversComponent {

    override fun driversKStore(): KStore<List<DriverEntity>> {
        val filesDir: String = ctx.filesDir.path
        return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
    }

}