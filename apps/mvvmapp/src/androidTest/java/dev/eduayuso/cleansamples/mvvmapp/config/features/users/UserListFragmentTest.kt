package dev.eduayuso.cleansamples.mvvmapp.config.features.users

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.eduayuso.cleansamples.mvvmapp.features.users.UserListFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class UserListFragmentTest: KoinTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testEventFragment() {

        // The "fragmentArgs" argument is optional.
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        val scenario = launchFragmentInContainer<UserListFragment>(fragmentArgs)
    }
}