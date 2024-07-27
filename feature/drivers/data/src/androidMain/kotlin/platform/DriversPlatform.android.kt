package platform

import android.content.Context
import applicationContext
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import local.DriverEntity
import okio.Path.Companion.toPath

internal actual fun createKStore(): KStore<List<DriverEntity>> {
    return drivers(applicationContext)
}

private fun drivers(ctx: Context): KStore<List<DriverEntity>> {
    val filesDir: String = ctx.filesDir.path
    return storeOf(file = "$filesDir/drivers.json".toPath(), default = emptyList())
}