package klt.mdy.sqldlitesample.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sample.userdb.UserEntity

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    items: List<UserEntity>,
    firstName: String,
    lastName: String,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onAddClicked: () -> Unit,
    onDeleteClicked: (UserEntity) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            itemsIndexed(items) { index, item ->
                NameItem(
                    index = index,
                    firstName = item.firstName,
                    lastName = item.lastName,
                    onDeleteClicked = {
                        onDeleteClicked(item)
                    }
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                value = firstName,
                onValueChange = onFirstNameChanged,
                placeholder = {
                    Text(text = "First Name")
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
            )
            Spacer(modifier = modifier.width(8.dp))
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                value = lastName,
                onValueChange = onLastNameChanged,
                placeholder = {
                    Text(text = "Last Name")
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),

            )
            Spacer(modifier = modifier.width(8.dp))
            IconButton(onClick = onAddClicked) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "done"
                )
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    Surface {
        MainContent(
            firstName = "",
            lastName = "",
            onFirstNameChanged = {},
            onLastNameChanged = {},
            onAddClicked = {},
            items = listOf(
                UserEntity(
                    id = 1,
                    firstName = "koko",
                    lastName = "kyaw"
                ),
                UserEntity(
                    id = 2,
                    firstName = "koko",
                    lastName = "Linn"
                ),
                UserEntity(
                    id = 3,
                    firstName = "koko",
                    lastName = "Thant"
                ),
                UserEntity(
                    id = 4,
                    firstName = "koko",
                    lastName = "kyawlinnthant"
                ),
            ),
            onDeleteClicked = {}
        )
    }
}