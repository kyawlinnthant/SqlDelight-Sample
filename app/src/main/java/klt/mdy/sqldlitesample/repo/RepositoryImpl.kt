package klt.mdy.sqldlitesample.repo

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import klt.mdy.sqldlitesample.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import sample.userdb.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    db: UserDatabase
) : Repository {
    private val queries = db.userEntityQueries
    override suspend fun getUserById(id: Long): UserEntity? {
        return withContext(Dispatchers.IO) {
            queries.getUserById(id).executeAsOneOrNull()
        }
    }

    override fun getAllUsers(): Flow<List<UserEntity>> {
        return queries.getAllUser().asFlow().mapToList()
    }

    override suspend fun deleteUserById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deletePersonById(id = id)
        }
    }

    override suspend fun insertUser(id: Long?, firstName: String, lastName: String) {
        withContext(Dispatchers.IO) {
            queries.insertUser(
                id = id,
                firstName = firstName,
                lastName = lastName
            )
        }
    }

}