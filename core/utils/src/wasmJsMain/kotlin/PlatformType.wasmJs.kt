
class WasmPlatform: Platform {
    override val name: String = "web/wasm"
    override val type: Type = Type.NON_MOBILE
}

actual fun getPlatform(): Platform = WasmPlatform()