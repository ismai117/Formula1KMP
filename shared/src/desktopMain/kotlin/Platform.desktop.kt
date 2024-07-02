class JVMPlatform: Platform {
    override val name: String = "desktop"
}

actual fun getPlatform(): Platform = JVMPlatform()