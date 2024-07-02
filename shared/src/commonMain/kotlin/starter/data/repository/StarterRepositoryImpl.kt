package starter.data.repository

import kotlinx.coroutines.flow.Flow
import starter.data.local.StarterLocalService
import starter.domain.repository.StarterRepository

class StarterRepositoryImpl(
    private val starterLocalService: StarterLocalService
) : StarterRepository {

    override suspend fun getStartedState(): Flow<Boolean?> {
       return starterLocalService.getStartedState()
    }

    override suspend fun setStartedState() {
       starterLocalService.setStartedState()
    }

}