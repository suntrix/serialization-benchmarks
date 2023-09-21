package suntrix.serialization.benchmarks.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubPush(
    val id: String,
    val type: String,
    val actor: Actor,
    val repo: Repo,
    val payload: Payload,
    val public: Boolean,
    @SerialName("created_at") val createdAt: String
) {
    @Serializable
    data class Actor(
        val id: Int,
        val login: String,
        @SerialName("gravatar_id") val gravatarId: String,
        val url: String,
        @SerialName("avatar_url") val avatarUrl: String
    )

    @Serializable
    data class Repo(
        val id: Int,
        val name: String,
        val url: String
    )

    @Serializable
    data class Payload(
        @SerialName("push_id") val pushId: Int? = null,
        val size: Int? = null,
        @SerialName("distinct_size") val distinctSize: Int? = null,
        val ref: String? = null,
        val head: String? = null,
        val before: String? = null,
        @SerialName("ref_type") val refType: String? = null,
        @SerialName("master_branch") val masterBranch: String? = null,
        val description: String? = null,
        @SerialName("pusher_type") val pusherType: String? = null
    )
}