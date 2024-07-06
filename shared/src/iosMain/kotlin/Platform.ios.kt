import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class IOSPlatform: Platform {
    override val name: String = "ios"
    override val type: Type = Type.MOBILE
    override val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
}

actual fun getPlatform(): Platform = IOSPlatform()