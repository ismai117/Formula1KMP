package ui.starter.domain.repository

interface StarterRepository {
    suspend fun getStartedState(): Boolean
    suspend fun setStartedState()
}