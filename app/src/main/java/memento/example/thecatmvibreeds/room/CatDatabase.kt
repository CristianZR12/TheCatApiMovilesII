package memento.example.thecatmvibreeds.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CatCacheEntity::class], version = 1)
abstract class CatDatabase: RoomDatabase()  {
    companion object{
        val DATABASE_NAME = "CatDB"
    }
    abstract fun catDao():CatDao
}