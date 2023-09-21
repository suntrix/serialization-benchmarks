package suntrix.serialization.benchmarks.model.moshi

import com.squareup.moshi.JsonClass

sealed class HtmlTag {

    @JsonClass(generateAdapter = true)
    data class Heading1(
        val text: String
    ) : HtmlTag()

    @JsonClass(generateAdapter = true)
    data class Heading2(
        val text: String
    ) : HtmlTag()

    @JsonClass(generateAdapter = true)
    data class Image(
        val src: String
    ) : HtmlTag()

    @JsonClass(generateAdapter = true)
    data class Paragraph(
        val text: String
    ) : HtmlTag()
}