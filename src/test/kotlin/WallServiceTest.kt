import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.posts.Post
import ru.netology.WallService
import ru.netology.exceptions.PostNotFoundException
import ru.netology.posts.Comment

class WallServiceTest {

    @Before
    fun prepareTest() {
        WallService.clear()
    }

    @Test
    fun addTest() {
        val post = WallService.add(Post(id = 0, text = "Post 1"))

        assertNotEquals(0, post.id)
    }

    @Test
    fun updateExistingTest() {
        val postOriginal = WallService.add(Post(id = 0, text = "Original post"))
        val postModified = Post(id = postOriginal.id, text = "Modified post")

        assertTrue(WallService.update(postModified))
    }

    @Test
    fun updateNonExistingTest() {
        val postOriginal = WallService.add(Post(id = 0, text = "Original post"))
        val postModified = Post(id = 0, text = "Modified post")

        assertFalse(WallService.update(postModified))
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentNoPost() {
        WallService.createComment(1, Comment(1, 2, 3, "Some comment"))
    }

    @Test
    fun createCommentExistPost() {
        WallService.add(Post(text="Post text"))
        val result = WallService.createComment(1, Comment(1, 2, 3, "Some comment"))

        assertNotNull(result)
    }
}