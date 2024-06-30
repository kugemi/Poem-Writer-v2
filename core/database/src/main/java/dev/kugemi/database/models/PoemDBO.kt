package dev.kugemi.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "POEMS")
data class PoemDBO(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("text") val text: String,
    @ColumnInfo("syllablesInfo") val syllablesInfo: String,
    @ColumnInfo("language") val language: Language,
)