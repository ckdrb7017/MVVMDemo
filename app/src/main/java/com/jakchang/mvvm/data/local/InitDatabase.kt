package  com.jakchang.mvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity

@Database(entities = [FavoriteTrackEntity::class], version = 1, exportSchema = false)
abstract class InitDatabase : RoomDatabase() {

    abstract fun localDao(): LocalApi
}

