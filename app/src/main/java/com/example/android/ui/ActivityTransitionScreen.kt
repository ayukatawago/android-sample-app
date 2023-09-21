package com.example.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.transition.TransitionType
import com.example.android.ui.theme.SampleAppTheme

@Composable
fun ActivityTransitionScreen(
    onButtonClicked: (TransitionType) -> Unit = {}
) {
    Column {
        TransitionType.values().forEach {
            Button(onClick = { onButtonClicked(it) }) {
                Text(text = "Open with ${it.description}")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    SampleAppTheme {
        ActivityTransitionScreen()
    }
}
