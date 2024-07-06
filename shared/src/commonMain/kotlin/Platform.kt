import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.Module

enum class Type {
    MOBILE,
    NON_MOBILE
}

interface Platform {
    val name: String
    val type: Type
    val dispatcherIO: CoroutineDispatcher
}

expect fun getPlatform(): Platform