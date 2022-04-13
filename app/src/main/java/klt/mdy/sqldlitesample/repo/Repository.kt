package klt.mdy.sqldlitesample.repo

import kotlinx.coroutines.flow.Flow
import sample.userdb.UserEntity

interface Repository {
    suspend fun getUserById(id: Long): UserEntity?
    fun getAllUsers(): Flow<List<UserEntity>>
    suspend fun deleteUserById(id: Long)
    suspend fun insertUser(
        id: Long? = null,
        firstName: String,
        lastName: String
    )
}