package teams.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamsDao {

    @Query("SELECT * FROM teams_table")
    fun selectTeams(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM teams_table WHERE name = :name")
    fun selectTeamByName(name: String): Flow<TeamEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(teamEntity: TeamEntity)

}