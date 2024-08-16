package net.ruggedodyssey.basic

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

fun nextSuit(suit: Suit): Suit = when (suit) {
    Suit.CLUB -> Suit.DIAMOND
    Suit.DIAMOND -> Suit.SPADE
    Suit.SPADE -> Suit.HEART
    Suit.HEART -> Suit.CLUB
}

@Composable
fun RedBlackCard(suit: Suit) {
    val imageModifier = Modifier.width(150.dp).height(200.dp).padding(32.dp)
    when (suit) {
        Suit.CLUB -> {
            Image(
                modifier = imageModifier,
                painter = painterResource("club.png"),
                contentDescription = "Club",
            )
        }
        Suit.DIAMOND -> {
            Image(
                modifier = imageModifier,
                painter = painterResource("diamond.png"),
                contentDescription = "Diamond",
            )
        }
        Suit.SPADE -> {
            Image(
                modifier = imageModifier,
                painter = painterResource("spade.png"),
                contentDescription = "Spade",
            )
        }
        Suit.HEART -> {
            Image(
                modifier = imageModifier,
                painter = painterResource("heart.png"),
                contentDescription = "Heart",
            )
        }
    }
}

enum class Suit {
    CLUB, DIAMOND, SPADE, HEART
}
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