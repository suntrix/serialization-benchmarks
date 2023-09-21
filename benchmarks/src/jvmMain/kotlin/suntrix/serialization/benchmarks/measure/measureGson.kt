package suntrix.serialization.benchmarks.measure

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

inline fun <reified Model> measureGson(
    titlePrefix: String,
    fileName: String
) {
    val gson = GsonBuilder().create()

    measure(
        title = "$titlePrefix - Gson",
        fileName = fileName,
        serializerFactory = { gson.getAdapter(TypeToken.get(Model::class.java)) },
        deserialize = { serializer, input -> serializer.fromJson(input) },
        serialize = { serializer, model -> serializer.toJson(model) }
    )
}