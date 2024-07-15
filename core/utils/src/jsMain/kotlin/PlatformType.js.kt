class JsPlatform: Platform {
    override val name: String = "web/js"
    override val type: Type = Type.NON_MOBILE
}

actual fun getPlatform(): Platform = JsPlatform()