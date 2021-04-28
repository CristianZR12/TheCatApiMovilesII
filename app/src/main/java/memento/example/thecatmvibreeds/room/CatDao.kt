package memento.example.thecatmvibreeds.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity:CatCacheEntity):Long
    @Query("select * from catBreeds")
    suspend fun get():List<CatCacheEntity>
}