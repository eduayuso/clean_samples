package dev.eduayuso.cleansamples.shared.impl.interactors

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.impl.di.TestsDepsInjection
import junit.framework.TestCase.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class PostsInteractorTest: KoinTest {

    val interactor by inject<IPostsUseCases>()
    val postId = "SFAt3mJK0qu4QOd9LgSX"

    @Before
    fun setUp() {

        TestsDepsInjection.config()
    }

    @Test
    fun fetchPostList() {

        runBlocking {

            try {

                /**
                 * Check fetch tag list as expected
                 */
                val posts = interactor.getPostList()
                assertNotNull(posts)
                assertEquals(posts.size, 10)

                /**
                 * Check there aren't repeated tags
                 */
                val distinctByIdList = posts.distinctBy { it.id }
                val checkPkIntegrity = posts.size == distinctByIdList.size
                assertTrue(checkPkIntegrity)

                /**
                 * Check tags from cache
                 */
                val postsInCache = interactor.getPostList()
                assertNotNull(postsInCache)
                assertEquals(posts.size, postsInCache.size)

            } catch (e: Exception) {
                fail("Error fetching tag list $e")
            }
        }
    }

    @Test
    fun fetchPostComments() {

        runBlocking {

            try {

                val comments = interactor.getPostComments(postId)

                /**
                 * Check expected result and some data
                 */
                assertNotNull(comments)
                assertEquals(comments!!.size, 4)

                /**
                 * Check there aren't repeated post ids
                 */
                val distinctByIdList = comments.distinctBy { it.id }
                val checkPkIntegrity = comments.size == distinctByIdList.size
                assertTrue(checkPkIntegrity)

            } catch (e: Exception) {
                fail("Error fetching tag list $e")
            }
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}