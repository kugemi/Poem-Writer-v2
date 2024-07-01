package dev.kugemi.rhymesapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class LanguageSerializable {
    // TODO: return uppercase 
    @SerialName("en")
    en,

    @SerialName("de")
    de,

    @SerialName("es")
    es,

    @SerialName("ru")
    ru,

    @SerialName("fr")
    fr,
}