package com.example.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.ui.theme.SampleAppTheme

@Composable
fun HomeScreen(
    onOpenSubActivityWithFade: () -> Unit = {},
    onOpenSubActivityWithSlide: () -> Unit = {},
    onOpenSubActivityWithMySlide: () -> Unit = {}
) {
    Column {
        Button(onClick = onOpenSubActivityWithFade) {
            Text(text = "Open with fade animation")
        }
        Button(onClick = onOpenSubActivityWithSlide) {
            Text(text = "Open with slide animation")
        }
        Button(onClick = onOpenSubActivityWithMySlide) {
            Text(text = "Open with my slide animation")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    SampleAppTheme {
        HomeScreen()
    }
}
