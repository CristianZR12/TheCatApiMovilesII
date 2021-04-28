package memento.example.thecatmvibreeds.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "catBreeds")
class CatCacheEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "id")
        var id:String,
        @ColumnInfo(name = "name")
        var name:String,
        @ColumnInfo(name = "description")
        var description:String
)