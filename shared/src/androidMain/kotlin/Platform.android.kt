import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidPlatform : Platform {
    override val name: String = "android"
    override val type: Type = Type.MOBILE
    override val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
}

actual fun getPlatform(): Platform = AndroidPlatform()
