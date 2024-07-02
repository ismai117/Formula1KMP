package drivers.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import main.drivers.data.local.DriverEntity

@Dao
interface DriversDao {

    @Query("SELECT * FROM drivers_table")
    fun selectDrivers(): Flow<List<DriverEntity>>

    @Query("SELECT * FROM drivers_table WHERE driverNumber = :driverNumber")
    fun selectDriverByDriverNumber(driverNumber: Int): Flow<DriverEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDriver(driverEntity: DriverEntity)

}