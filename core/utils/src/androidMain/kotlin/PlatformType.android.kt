
class AndroidPlatform : Platform {
    override val name: String = "android"
    override val type: Type = Type.MOBILE
}

actual fun getPlatform(): Platform = AndroidPlatform()