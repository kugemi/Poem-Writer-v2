package dev.kugemi.database.utils

import androidx.room.TypeConverter
import dev.kugemi.database.models.Language

internal class Converters {
    @TypeConverter
    fun toLanguage(value: String) = enumValueOf<Language>(value)

    @TypeConverter
    fun fromHealth(value: Language) = value.name
}