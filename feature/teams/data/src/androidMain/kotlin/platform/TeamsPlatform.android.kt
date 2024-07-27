package platform

import android.content.Context
import applicationContext
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import local.TeamEntity
import okio.Path.Companion.toPath

internal actual fun createKStore(): KStore<List<TeamEntity>> {
    return teams(applicationContext)
}

private fun teams(ctx: Context): KStore<List<TeamEntity>> {
    val filesDir: String = ctx.filesDir.path
    return storeOf(file = "$filesDir/teams.json".toPath(), default = emptyList())
}