import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.ruggedodyssey.basic.RedBlackCard
import net.ruggedodyssey.basic.Suit
import net.ruggedodyssey.basic.nextSuit

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwitchCard(crossFade: Boolean = false) {
    var suit by remember { mutableStateOf(Suit.HEART) }
    Card(
        modifier = Modifier
            .padding(16.dp),
        elevation = 10.dp,
        onClick = { suit = nextSuit(suit) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (crossFade) {
                Crossfade(
                    targetState = suit,
                    animationSpec = tween(3000)
                ) { suit ->
                    RedBlackCard(suit)
                }
            } else {
                RedBlackCard(suit)
            }
        }
    }
}

@Preview
@Composable
fun SwitchCardPreview() {
    SwitchCard(true)
}