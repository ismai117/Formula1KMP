package starter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import local.StarterLocalService
import me.tatarka.inject.annotations.Inject

@Inject
class StarterRepositoryImpl(
    private val local: StarterLocalService
) : StarterRepository {

    override suspend fun getStartedState(): Flow<Boolean?> {
       return flowOf(local.getStartedState())
    }

    override suspend fun setStartedState() {
       local.setStartedState()
    }

}