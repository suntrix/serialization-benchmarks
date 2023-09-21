package suntrix.serialization.benchmarks.measure

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

inline fun <reified Model> measureKotlinxSerialization(
    titlePrefix: String,
    fileName: String
) {
    val json = Json {
        ignoreUnknownKeys = true
    }

    measure(
        title = "$titlePrefix - kotlinx.serialization",
        fileName = fileName,
        serializerFactory = { serializer<Model>() },
        deserialize = { serializer, input -> json.decodeFromString(serializer, input) },
        serialize = { serializer, model -> json.encodeToString(serializer, model) }
    )
}