package net.ruggedodyssey.basic

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.ruggedodyssey.data.rabbitDescription
import net.ruggedodyssey.data.rabbitDescriptionShort
import net.ruggedodyssey.data.rabbitTitle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SampleCard2(title: String, shortDescription: String, longDescription: String) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 10.dp,
        onClick = { expanded = !expanded }
    ) {
        Row {
            Rabbit()
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    text = if (expanded) longDescription else shortDescription,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .padding(16.dp)
                        .animateContentSize(animationSpec = tween(3000))
                )
            }
        }
    }
}

@Preview
@Composable
fun SampleCardPreview() {
    SampleCard2(
        title = rabbitTitle,
        shortDescription = rabbitDescriptionShort,
        longDescription = rabbitDescription
    )
}