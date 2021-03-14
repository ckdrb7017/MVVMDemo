package  com.changgyu.watcha.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.changgyu.watcha.data.entity.FavoriteTrackEntity

//데이터베이스 초기화
@Database(entities = [FavoriteTrackEntity::class], version = 1, exportSchema = false)
abstract class InitDatabase : RoomDatabase() {

    abstract fun localDao(): LocalApi
}

