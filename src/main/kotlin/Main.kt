package ru.netology

import ru.netology.exceptions.PostNotFoundException
import ru.netology.posts.Comment
import ru.netology.posts.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        // HINT: Пока нет функции удаления, будем использовать индекс массива в качестве основы уникального ID поста.
        // Впоследствии можно брать за основу текущую метку времени с мс или завести отдельный счетчик.
        // Ну и заменить Array на Map.
        posts += post.copy(id = posts.size + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        // HINT: Поскольку использован индекс массива в качестве ID поста, выбираем элемент по этому индексу.
        if ((post.id - 1) > -1 && (post.id - 1) < posts.count()) {
            // Пост найден. Заменяем его
            posts[post.id - 1] = post
            return true
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        if ((postId < 1) || (posts.size < postId))
            throw PostNotFoundException("Specified post with ID=$postId does not found")
        comments += comment.copy();
        return comments[comments.size - 1];
    }
}

fun main(args: Array<String>) {
    WallService.createComment(1, Comment(1, 2, 3, "Some comment"))
}