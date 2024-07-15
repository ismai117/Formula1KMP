
class JVMPlatform: Platform {
    override val name: String = "desktop"
    override val type: Type = Type.NON_MOBILE
}

actual fun getPlatform(): Platform = JVMPlatform()