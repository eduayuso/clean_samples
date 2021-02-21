package dev.eduayuso.cleansamples.mvvmapp.features

import dev.eduayuso.cleansamples.shared.domain.entities.LocationEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases

// TODO Mockwebserver
class UsersMockInteractor: IUsersUseCases {

    private val user1 =
        UserEntity(
            id = "a",
            firstName = "Edu",
            lastName = "Rodriguez",
            picture = "https://randomuser.me/api/portraits/men/81.jpg",
            email = "eduayuso@gmail.com"
        )

    private val user2 =
        UserEntity(
            id = "b",
            firstName = "Edu2",
            lastName = "Rodriguez2",
            email = "eduayuso2@gmail.com"
        )

    private val post1 =
        PostEntity(
            id = "p1",
            text = "asdf",
            image = "https://randomuser.me/api/portraits/men/81.jpg"
        )

    private val post2 =
        PostEntity(
            id = "p1",
            text = "asdf",
            image = "https://randomuser.me/api/portraits/men/81.jpg"
        )

    private val _userListEmpty = emptyList<UserEntity>()
    private val _userListNotEmpty = listOf(user1, user2)
    private val _postListEmpty = emptyList<UserEntity>()
    private val _postListNotEmpty = listOf(post1, post2)

    private var _userList: List<UserEntity>? = null
    private var _user: UserEntity? = null
    private var _postList: List<PostEntity>? = null

    fun setMockUserListEmpty() {
        _userList = _userListEmpty
    }

    fun setMockUserListNotEmpty() {
        _userList = _userListNotEmpty
    }

    fun setMockUser() {
        _user = user1
    }

    fun setFullUser() {
        user1.apply {
            location = LocationEntity("a,", "b", "c", "d", "e")
        }
    }

    override suspend fun getUserList() = _userList ?: emptyList()

    override suspend fun getUserDetail(id: String) = user1

    override suspend fun getUserPosts(id: String) = _postList ?: emptyList()
}