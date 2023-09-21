package suntrix.serialization.benchmarks

import suntrix.serialization.benchmarks.measure.*

fun main() {
//    measureGson<suntrix.serialization.benchmarks.model.gson.UserProfile>(
//        titlePrefix = "Standard model",
//        fileName = "standard-model.json"
//    )
//    measureKotlinxSerialization<suntrix.serialization.benchmarks.model.UserProfile>(
//        titlePrefix = "Standard model",
//        fileName = "standard-model.json"
//    )
//    measureMoshi<suntrix.serialization.benchmarks.model.moshi.UserProfile>(
//        titlePrefix = "Standard model",
//        fileName = "standard-model.json"
//    )

//    measureKotlinxSerialization<List<suntrix.serialization.benchmarks.model.HtmlTag>>(
//        titlePrefix = "Sealed class",
//        fileName = "sealed-class.json"
//    )
//    measureMoshiSealedClass<List<suntrix.serialization.benchmarks.model.moshi.HtmlTag>>(
//        titlePrefix = "Sealed class",
//        fileName = "sealed-class.json"
//    )

//    measureGson<List<suntrix.serialization.benchmarks.model.gson.GithubPush>>(
//        titlePrefix = "Large list",
//        fileName = "large-list.json"
//    )
//    measureKotlinxSerialization<List<suntrix.serialization.benchmarks.model.GithubPush>>(
//        titlePrefix = "Large list",
//        fileName = "large-list.json"
//    )
//    measureMoshi<List<suntrix.serialization.benchmarks.model.moshi.GithubPush>>(
//        titlePrefix = "Large list",
//        fileName = "large-list.json"
//    )

    measureKotlinxSerialization<List<suntrix.serialization.benchmarks.model.MacOsRelease>>(
        titlePrefix = "macOS releases",
        fileName = "macosx-releases.json"
    )
}

