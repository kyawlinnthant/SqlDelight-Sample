package klt.mdy.sqldlitesample.screen.udf

import sample.userdb.UserEntity

data class States(
    val users: List<UserEntity> = listOf(),
    val firstName: String = "",
    val lastName: String = "",
)
