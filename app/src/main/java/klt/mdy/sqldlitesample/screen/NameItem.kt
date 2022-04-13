package klt.mdy.sqldlitesample.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NameItem(
    modifier: Modifier = Modifier,
    index : Int,
    firstName: String,
    lastName: String,
    onDeleteClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),
            text = "${index+1} . $firstName $lastName"
        )
        Spacer(modifier = modifier.width(8.dp))
        IconButton(onClick = onDeleteClicked) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete"
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    Surface {
        NameItem(
            index = 0,
            firstName = "Kyaw",
            lastName = "Thant",
            onDeleteClicked = {}
        )
    }
}