package dev.eduayuso.cleansamples.shared.impl.interactors

import android.util.Log
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.impl.di.TestsDepsInjection
import junit.framework.TestCase.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin

@RunWith(JUnit4::class)
class UsersInteractorTest {

    private lateinit var interactor: UsersInteractor
    val userId = "0F8JIqi4zwvb77FGz6Wt"

    @Before
    fun setUp() {

        TestsDepsInjection.config()
        this.interactor = UsersInteractor()
    }

    @Test
    fun fetchUserList() {

        runBlocking {

            try {

                /**
                 * Check fetch user list as expected
                 */
                val users = interactor.getUserList()
                assertNotNull(users)
                assertEquals(users.size, 10)

                /**
                 * GET user list returns user entity without attribute location,
                 * which is retrieved only in GET user detail
                 */
                val usersHaveNotLocation = users.all { it.location == null }
                assertTrue(usersHaveNotLocation)

                /**
                 * Check there aren't repeated user ids
                 */
                val distinctByIdList = users.distinctBy { it.id }
                val checkPkIntegrity = users.size == distinctByIdList.size
                assertTrue(checkPkIntegrity)

            } catch (e: Exception) {
                Log.e("Error fetching user list", e.toString())
            }
        }
    }

    @Test
    fun fetchUserDetail() {

        runBlocking {

            try {

                val user = interactor.getUserDetail(userId)

                /**
                 * Check expected result and some data
                 */
                assertNotNull(user)
                assertEquals(user!!.id, userId)
                assertEquals(user!!.email, "heinz-georg.fiedler@example.com")

                /**
                 * Check expected attribute 'location' exists
                 */
                assertNotNull(user.location)

            } catch (e: Exception) {
                Log.e("Error fetching user list", e.toString())
            }
        }
    }

    @Test
    fun fetchUserPosts() {

        runBlocking {

            try {

                val posts = interactor.getUserPosts(userId)

                /**
                 * Check expected result and some data
                 */
                assertNotNull(posts)
                assertEquals(posts!!.size, 5)

                /**
                 * Check posts owner as expected
                 */
                val ownerCheck = posts.all { it.owner?.id == userId }
                assertTrue(ownerCheck)

                /**
                 * Check there aren't repeated user ids
                 */
                val distinctByIdList = posts.distinctBy { it.id }
                val checkPkIntegrity = posts.size == distinctByIdList.size
                assertTrue(checkPkIntegrity)

            } catch (e: Exception) {
                Log.e("Error fetching user list", e.toString())
            }
        }
    }

    @After
    fun tearDown() {

    }
}