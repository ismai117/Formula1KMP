package org.ncgroup.formula1kmp.starter.data.repository

import kotlinx.coroutines.flow.Flow
import org.ncgroup.formula1kmp.starter.data.local.StarterLocalService
import starter.domain.repository.StarterRepository

class StarterRepositoryImpl(
    private val localService: StarterLocalService
) : StarterRepository {

    override suspend fun getStartedState(): Flow<Boolean?> {
       return localService.getStartedState()
    }

    override suspend fun setStartedState() {
       localService.setStartedState()
    }

}