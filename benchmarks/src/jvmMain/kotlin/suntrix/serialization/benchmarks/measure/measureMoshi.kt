package suntrix.serialization.benchmarks.measure

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

@OptIn(ExperimentalStdlibApi::class)
inline fun <reified Model> measureMoshi(
    titlePrefix: String,
    fileName: String
) {
    val moshi = Moshi.Builder().build()

    measure(
        title = "$titlePrefix - Moshi",
        fileName = fileName,
        serializerFactory = { moshi.adapter<Model>() },
        deserialize = { serializer, input -> serializer.fromJson(input) },
        serialize = { serializer, model -> serializer.toJson(model) }
    )
}