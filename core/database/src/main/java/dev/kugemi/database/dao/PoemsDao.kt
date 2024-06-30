package dev.kugemi.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.kugemi.database.models.Language
import dev.kugemi.database.models.PoemDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface PoemsDao {
    @Query("SELECT * FROM POEMS")
    suspend fun getPoems(): List<PoemDBO>

    @Query("SELECT * FROM POEMS")
    suspend fun observePoems(): Flow<List<PoemDBO>>

    @Query("SELECT EXISTS(SELECT * FROM POEMS WHERE id = :id)")
    suspend fun isPoemIsExist(id : Int): Boolean

    @Delete
    suspend fun removePoem(poem : PoemDBO)

    @Insert
    suspend fun insertPoem(poem : PoemDBO)

    @Query("UPDATE POEMS SET title = :newTitle WHERE id = :id")
    suspend fun updateTitle(newTitle : String, id : Int)

    @Query("UPDATE POEMS SET text = :newText WHERE id = :id")
    suspend fun updateText(newText : String, id : Int)

    @Query("UPDATE POEMS SET syllablesInfo = :newSyllablesInfo WHERE id = :id")
    suspend fun updateSyllables(newSyllablesInfo : String, id : Int)

    @Query("UPDATE POEMS SET language = :newLanguage WHERE id = :id")
    suspend fun updateLanguage(newLanguage : Language, id : Int)
}