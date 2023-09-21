package suntrix.serialization.benchmarks

import suntrix.serialization.benchmarks.measure.*

fun main() {
//    measureKotlinxSerialization<suntrix.serialization.benchmarks.model.UserProfile>(
//        titlePrefix = "Standard model",
//        fileName = "standard-model.json"
//    )

//    measureKotlinxSerialization<List<suntrix.serialization.benchmarks.model.HtmlTag>>(
//        titlePrefix = "Sealed class",
//        fileName = "sealed-class.json"
//    )

//    measureKotlinxSerialization<List<suntrix.serialization.benchmarks.model.GithubPush>>(
//        titlePrefix = "Large list",
//        fileName = "large-list.json"
//    )

    measureKotlinxSerialization<List<suntrix.serialization.benchmarks.model.MacOsRelease>>(
        titlePrefix = "macOS releases",
        fileName = "macosx-releases.json"
    )
}

