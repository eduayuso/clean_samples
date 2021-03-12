package dev.eduayuso.cleansamples.shared.impl.interactors

import android.util.Log
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
class TagsInteractorTest: KoinTest{

    val interactor by inject<ITagsUseCases>()
    val tagId = "water"

    @Before
    fun setUp() {

        TestsDepsInjection.config()
    }

    @Test
    fun fetchTagList() {

        runBlocking {

            try {

                /**
                 * Check fetch tag list as expected
                 */
                val tags = interactor.getTagList()
                assertNotNull(tags)
                assertEquals(tags.size, 20)

                /**
                 * Check there aren't repeated tags
                 */
                val distinctByIdList = tags.distinctBy { it.id }
                val checkPkIntegrity = tags.size == distinctByIdList.size
                assertTrue(checkPkIntegrity)

                /**
                 * Check tags from cache
                 */
                val tagsInCache = interactor.getTagList()
                assertNotNull(tagsInCache)
                assertEquals(tags.size, tagsInCache.size)

            } catch (e: Exception) {
                fail("Error fetching tag list $e")
            }
        }
    }

    @Test
    fun fetchPostByTag() {

        runBlocking {

            try {

                val posts = interactor.getPostsByTag(tagId)

                /**
                 * Check expected result and some data
                 */
                assertNotNull(posts)
                assertEquals(posts!!.size, 10)

                /**
                 * Check posts contains tag
                 */
                val containsTag = posts.all { it.tags?.contains(tagId) == true }
                assertTrue(containsTag)

                /**
                 * Check there aren't repeated post ids
                 */
                val distinctByIdList = posts.distinctBy { it.id }
                val checkPkIntegrity = posts.size == distinctByIdList.size
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