package suntrix.serialization.benchmarks.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class HtmlTag {

    @SerialName("h1")
    @Serializable
    data class Heading1(
        val text: String
    ) : HtmlTag()

    @SerialName("h2")
    @Serializable
    data class Heading2(
        val text: String
    ) : HtmlTag()

    @SerialName("img")
    @Serializable
    data class Image(
        val src: String
    ) : HtmlTag()

    @SerialName("p")
    @Serializable
    data class Paragraph(
        val text: String
    ) : HtmlTag()
}