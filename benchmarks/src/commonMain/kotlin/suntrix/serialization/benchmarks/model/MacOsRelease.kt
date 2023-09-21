package suntrix.serialization.benchmarks.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MacOsRelease(
    val name: String,
    val version: String,
    val darwin: String,
    @SerialName("release_date") val releaseDate: String,
    val architectures: List<String>
)

//enum class Architecture {
//    arm64,
//    ppc,
//    x86,
//    x86_64
//}