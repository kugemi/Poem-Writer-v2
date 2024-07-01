package dev.kugemi.rhymesapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class LanguageSerializable {
    @SerialName("en")
    EN,

    @SerialName("de")
    DE,

    @SerialName("es")
    ES,

    @SerialName("ru")
    RU,

    @SerialName("fr")
    FR,
}