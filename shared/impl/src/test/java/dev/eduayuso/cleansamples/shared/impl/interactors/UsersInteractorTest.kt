package dev.eduayuso.cleansamples.shared.impl.interactors

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UsersInteractorTest {

    private lateinit var interactor: UsersInteractor

    @Before
    fun setUp() {

        this.interactor = UsersInteractor()
    }

    @Test
    fun fetchEmptyUserList() {

        runBlocking {
            interactor.getUserList()
        }
    }

    @Test
    fun fetchUserList() {

    }

    @Test
    fun fetchUserDetail() {

    }

    @After
    fun tearDown() {

    }
}