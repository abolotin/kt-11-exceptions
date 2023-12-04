package ru.netology.posts

import ru.netology.attachments.Attachment

data class Comment(
    val id : Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut? = null,
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: Array<Attachment>? = null,
    val parentsStack: Array<Int>? = null,
    val thread : Thread? = null,

) {
    data class Thread (
        val count: Int = 0,
        val items: Array<Comment>? = null,
        val canPost: Boolean = false,
        val showReplyButton: Boolean = false,
        val groupsCanPost: Boolean = false
    )
}
