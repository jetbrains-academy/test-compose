package net.ruggedodyssey.basic

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Rabbit(modifier: Modifier = Modifier) {

    Image(
        modifier = modifier.size(120.dp),
        painter = painterResource("rabbit.png"),
        contentDescription = "Rabbit",
    )

}

@Preview
@Composable
fun RabbitPreview() {
    Rabbit()
}