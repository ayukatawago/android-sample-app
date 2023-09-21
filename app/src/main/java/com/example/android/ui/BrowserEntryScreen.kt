package com.example.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.browser.UrlItem
import com.example.android.ui.theme.SampleAppTheme

@Composable
fun BrowserEntryScreen(
    onButtonClicked: (UrlItem) -> Unit = {}
) {
    Column {
        UrlItem.values().forEach {
            Button(onClick = { onButtonClicked(it) }) {
                Text(text = "Open ${it.url}")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BrowserEntryScreenPreview() {
    SampleAppTheme {
        BrowserEntryScreen()
    }
}
