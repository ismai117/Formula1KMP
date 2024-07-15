
class IOSPlatform: Platform {
    override val name: String = "ios"
    override val type: Type = Type.MOBILE
}

actual fun getPlatform(): Platform = IOSPlatform()