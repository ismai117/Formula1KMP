package starter.domain.repository

import kotlinx.coroutines.flow.Flow

interface StarterRepository {
    suspend fun getStartedState(): Flow<Boolean?>
    suspend fun setStartedState()
}