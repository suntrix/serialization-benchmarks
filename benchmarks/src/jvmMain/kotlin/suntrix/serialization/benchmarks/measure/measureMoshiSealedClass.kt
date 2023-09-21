package suntrix.serialization.benchmarks.measure

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import suntrix.serialization.benchmarks.model.moshi.HtmlTag

@OptIn(ExperimentalStdlibApi::class)
inline fun <reified Model> measureMoshiSealedClass(
    titlePrefix: String,
    fileName: String
) {
    val moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(HtmlTag::class.java, "type")
                .withSubtype(HtmlTag.Heading1::class.java, "h1")
                .withSubtype(HtmlTag.Heading2::class.java, "h2")
                .withSubtype(HtmlTag.Image::class.java, "img")
                .withSubtype(HtmlTag.Paragraph::class.java, "p")
        )
        .build()

    measure(
        title = "$titlePrefix - Moshi",
        fileName = fileName,
        serializerFactory = { moshi.adapter<Model>() },
        deserialize = { serializer, input -> serializer.fromJson(input) },
        serialize = { serializer, model -> serializer.toJson(model) }
    )
}