package commonMain

import local.StarterLocalService
import starter.StarterRepository
import starter.StarterRepositoryImpl

object StarterModule {
    private val starterLocalService: StarterLocalService by lazy {
        StarterLocalService()
    }
    val starterRepository: StarterRepository by lazy {
        StarterRepositoryImpl(starterLocalService)
    }
}