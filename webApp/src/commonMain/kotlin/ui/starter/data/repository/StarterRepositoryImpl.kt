package starter.data.repository

import kotlinx.coroutines.flow.Flow
import ui.starter.data.local.StarterLocalService
import ui.starter.domain.repository.StarterRepository

class StarterRepositoryImpl(
    private val starterLocalService: StarterLocalService
) : StarterRepository {

    override suspend fun getStartedState(): Boolean {
       return starterLocalService.getStartedState()
    }

    override suspend fun setStartedState() {
       starterLocalService.setStartedState()
    }

}