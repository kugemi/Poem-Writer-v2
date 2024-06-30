package dev.kugemi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.kugemi.database.dao.PoemsDao
import dev.kugemi.database.models.PoemDBO

class PoemsDatabase internal constructor(private val database: PoemRoomDatabase) {
    val poemsDao: PoemsDao
        get() = database.poemsDao()
}

@Database(entities = [PoemDBO::class], version = 1)
internal abstract class PoemRoomDatabase : RoomDatabase() {
    abstract fun poemsDao(): PoemsDao
}

fun PoemsDatabase(applicationContext: Context): PoemsDatabase {
    val poemsRoomDatabase = Room.databaseBuilder(
        context = checkNotNull(applicationContext.applicationContext),
        PoemRoomDatabase::class.java,
        "poems"
    ).build()
    return PoemsDatabase(poemsRoomDatabase)
}