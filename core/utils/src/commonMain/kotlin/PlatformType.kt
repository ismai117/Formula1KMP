
enum class Type {
    MOBILE,
    NON_MOBILE
}

interface Platform {
    val name: String
    val type: Type
}

expect fun getPlatform(): Platform