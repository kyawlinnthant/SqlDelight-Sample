package klt.mdy.sqldlitesample.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import klt.mdy.sqldlitesample.screen.udf.Actions
import klt.mdy.sqldlitesample.screen.udf.Events
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainView() {
    val vm: MainViewModel = hiltViewModel()
    val state = vm.states.value
    LaunchedEffect(key1 = true) {
        vm.events.collectLatest {
            when (it) {
                Events.DeleteItem -> {

                }
            }
        }
    }

    MainContent(
        firstName = state.firstName,
        lastName = state.lastName,
        onFirstNameChanged = {
            vm.onAction(
                Actions.OnFirstNameChanged(
                    firstName = it
                )
            )
        },
        onLastNameChanged = {
            vm.onAction(
                Actions.OnLastNameChanged(
                    lastName = it
                )
            )
        },
        onAddClicked = {
            vm.onAction(
                Actions.InsertItem
            )
        },
        items = state.users,
        onDeleteClicked = {
            vm.onAction(
                Actions.DeleteItem(
                    item = it
                )
            )
        }
    )
}