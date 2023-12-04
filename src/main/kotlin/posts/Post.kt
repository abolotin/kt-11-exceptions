package ru.netology.posts

import ru.netology.attachments.Attachment

data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val formId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String,
    val replyOwnerId: Int = 0,
    val friendsOnly: Boolean = false,
    val postType: String = "",
    val comments: PostComments? = null,
    val likes: PostLikes? = null,
    var attachments: Array<Attachment>? = null
) {
    data class PostComments(
        val count: Int = 0,
        val canPost: Boolean = false,
        val groupsCanPost: Boolean = false,
        val canClose: Boolean = false,
        val canOpen: Boolean = false
    )

    data class PostLikes(
        val count: Int = 0,
        val userLikes: Boolean = false,
        val canLike: Boolean = false,
        val canPublish: Boolean = false
    )
}
