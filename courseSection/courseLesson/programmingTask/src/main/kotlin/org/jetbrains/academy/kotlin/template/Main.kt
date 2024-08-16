import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.ruggedodyssey.basic.SampleCard2
import net.ruggedodyssey.data.rabbitDescription
import net.ruggedodyssey.data.rabbitDescriptionShort
import net.ruggedodyssey.data.rabbitTitle

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Column {
            Button(onClick = {
                text = "Hello, Desktop!"
            }) {
                Text(text)
            }
            SampleCard2(
                title = rabbitTitle,
                shortDescription = rabbitDescriptionShort,
                longDescription = rabbitDescription
            )
            SwitchCard(true)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
