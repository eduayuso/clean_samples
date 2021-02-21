package dev.eduayuso.cleansamples.mvvmapp.features

import org.junit.Assert
import org.junit.Test

// TODO Mockwebserver
class UsersUseCasesTests {

    private val interactor = UsersMockInteractor()

    @Test
    suspend fun fetchEmptyUserList() {

        interactor.setMockUserListEmpty()
        val users = interactor.getUserList()
        Assert.assertTrue(users.isEmpty())
    }

    @Test
    suspend fun fetchUserList() {

        interactor.setMockUserListNotEmpty()
        val users = interactor.getUserList()
        Assert.assertFalse(users.isEmpty())
    }

    @Test
    suspend fun fetchUserDetail() {

        interactor.setMockUserListNotEmpty()

        val users = interactor.getUserList()
        val user = users.first()
        val id = user.id

        // User is not full (without details -> location == null)
        Assert.assertNull(user.location)

        interactor.setFullUser()
        Assert.assertNotNull(id)

        val fullUser = interactor.getUserDetail(id!!)
        Assert.assertNotNull(fullUser)

        // User is full, with details like 'location'
        Assert.assertNotNull(user.location)
    }
}