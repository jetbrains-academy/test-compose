package net.ruggedodyssey.basic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.ruggedodyssey.data.sampleWords

@Composable
fun LabelList(label: String) {
    Text(
        text = label,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun SampleList(entries: List<String> = sampleWords) {
    Column {
        entries.forEach { item ->
            LabelList(item)
        }
    }
}

@Composable
fun SampleList2(entries: List<String> = sampleWords) {
    LazyColumn {
        items(entries.size) { index ->
            LabelList(entries[index])
        }
    }
}
