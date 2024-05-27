package starter.domain.repository

import kotlinx.coroutines.flow.Flow

interface StarterRepository {
    fun getStartedState(): Flow<Boolean?>
    suspend fun setStartedState(value: Boolean)
}