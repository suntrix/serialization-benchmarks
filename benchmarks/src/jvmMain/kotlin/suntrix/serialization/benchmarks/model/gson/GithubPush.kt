package suntrix.serialization.benchmarks.model.gson

import com.google.gson.annotations.SerializedName

data class GithubPush(
    val id: String,
    val type: String,
    val actor: Actor,
    val repo: Repo,
    val payload: Payload,
    val public: Boolean,
    @SerializedName("created_at") val createdAt: String
) {
    data class Actor(
        val id: Int,
        val login: String,
        @SerializedName("gravatar_id") val gravatarId: String,
        val url: String,
        @SerializedName("avatar_url") val avatarUrl: String
    )

    data class Repo(
        val id: Int,
        val name: String,
        val url: String
    )

    data class Payload(
        @SerializedName("push_id") val pushId: Int? = null,
        val size: Int? = null,
        @SerializedName("distinct_size") val distinctSize: Int? = null,
        val ref: String? = null,
        val head: String? = null,
        val before: String? = null,
        @SerializedName("ref_type") val refType: String? = null,
        @SerializedName("master_branch") val masterBranch: String? = null,
        val description: String? = null,
        @SerializedName("pusher_type") val pusherType: String? = null
    )
}