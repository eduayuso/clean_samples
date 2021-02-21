package dev.eduayuso.cleansamples.mvvmapp.features

import androidx.test.core.app.ActivityScenario.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

// TODO Mockwebserver
class UsersUseCasesTests {

    private val interactor = UsersMockInteractor()

    @Before
    fun setUp() {
    }

    @Test
    fun fetchEmptyUserList() {

        interactor.setMockUserListEmpty()
        runBlockingTest {
            val users = interactor.getUserList()
            Assert.assertTrue(users.isEmpty())
        }
    }

    @Test
    fun fetchUserList() {

        interactor.setMockUserListNotEmpty()
        runBlockingTest {
            val users = interactor.getUserList()
            Assert.assertFalse(users.isEmpty())
        }
    }

    @Test
    fun fetchUserDetail() {

        interactor.setMockUserListNotEmpty()
        var id: String? = null

        runBlockingTest {
            val users = interactor.getUserList()
            val user = users.first()
            id = user.id
            // User is not full (without details -> location == null)
            Assert.assertNull(user.location)
        }

        interactor.setFullUser()
        Assert.assertNotNull(id)

        runBlockingTest {
            val fullUser = interactor.getUserDetail(id!!)
            Assert.assertNotNull(fullUser)
            // User is full, with details like 'location'
            Assert.assertNotNull(fullUser.location)
        }
    }

    @After
    fun tearDown() {
    }
}