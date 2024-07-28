import commonMain.DriversComponent
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import local.DriverEntity
import me.tatarka.inject.annotations.Component

@Component
abstract class JsDriversComponent : DriversComponent{

    override fun driversKStore(): KStore<List<DriverEntity>> {
        return storeOf(key = "drivers", default = emptyList())
    }

}