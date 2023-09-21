package suntrix.serialization.benchmarks.model.moshi

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubPush(
    val id: String,
    val type: String,
    val actor: Actor,
    val repo: Repo,
    val payload: Payload,
    val public: Boolean,
    @Json(name = "created_at") val createdAt: String
) {
    @JsonClass(generateAdapter = true)
    data class Actor(
        val id: Int,
        val login: String,
        @Json(name = "gravatar_id") val gravatarId: String,
        val url: String,
        @Json(name = "avatar_url") val avatarUrl: String
    )

    @JsonClass(generateAdapter = true)
    data class Repo(
        val id: Int,
        val name: String,
        val url: String
    )

    @JsonClass(generateAdapter = true)
    data class Payload(
        @Json(name = "push_id") val pushId: Int? = null,
        val size: Int? = null,
        @Json(name = "distinct_size") val distinctSize: Int? = null,
        val ref: String? = null,
        val head: String? = null,
        val before: String? = null,
        @Json(name = "ref_type") val refType: String? = null,
        @Json(name = "master_branch") val masterBranch: String? = null,
        val description: String? = null,
        @Json(name = "pusher_type") val pusherType: String? = null
    )
}