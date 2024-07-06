import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class JVMPlatform: Platform {
    override val name: String = "desktop"
    override val type: Type = Type.NON_MOBILE
    override val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
}

actual fun getPlatform(): Platform = JVMPlatform()