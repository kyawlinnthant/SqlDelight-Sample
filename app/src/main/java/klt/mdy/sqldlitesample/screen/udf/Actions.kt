package klt.mdy.sqldlitesample.screen.udf

import sample.userdb.UserEntity

sealed class Actions {
    object InsertItem : Actions()
    data class DeleteItem(val item: UserEntity) : Actions()
    data class OnFirstNameChanged(val firstName: String) : Actions()
    data class OnLastNameChanged(val lastName: String) : Actions()
}
