package klt.mdy.sqldlitesample.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import klt.mdy.sqldlitesample.repo.Repository
import klt.mdy.sqldlitesample.screen.udf.Actions
import klt.mdy.sqldlitesample.screen.udf.Events
import klt.mdy.sqldlitesample.screen.udf.States
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import sample.userdb.UserEntity
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {
    private val _states = mutableStateOf(States())
    val states: State<States> get() = _states

    private val _events = MutableSharedFlow<Events>()
    val events: SharedFlow<Events> get() = _events

    init {
        viewModelScope.launch {
            repo.getAllUsers().collect {
                _states.value = states.value.copy(
                    users = it
                )
            }
        }
    }

    fun onAction(action: Actions) {
        when (action) {
            is Actions.DeleteItem -> {
                deleteItem(item = action.item)
            }
            is Actions.InsertItem -> {
                insertItem()
            }
            is Actions.OnFirstNameChanged -> {
                _states.value = states.value.copy(
                    firstName = action.firstName
                )
            }
            is Actions.OnLastNameChanged -> {
                _states.value = states.value.copy(
                    lastName = action.lastName
                )
            }
        }
    }

    private fun deleteItem(item: UserEntity) {
        viewModelScope.launch {
            repo.deleteUserById(id = item.id)
        }
    }

    private fun insertItem() {
        val firstName = states.value.firstName
        val lastName = states.value.lastName
        if (firstName.isBlank() || lastName.isBlank()) {
            return
        }
        viewModelScope.launch {
            repo.insertUser(
                firstName = firstName,
                lastName = lastName
            )
        }
        _states.value = states.value.copy(
            firstName = "",
            lastName = ""
        )
    }

}