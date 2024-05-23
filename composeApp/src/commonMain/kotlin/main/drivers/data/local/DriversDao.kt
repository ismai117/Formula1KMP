package main.drivers.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DriversDao {

    @Query("SELECT * FROM drivers_table")
    fun selectDrivers(): Flow<List<DriverEntity>>

    @Query("SELECT * FROM drivers_table WHERE driverNumber = :driverNumber")
    fun selectDriverByDriverNumber(driverNumber: Int): Flow<DriverEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDriver(driverEntity: DriverEntity)

}