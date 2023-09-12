package com.example.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.ui.theme.SampleAppTheme

@Composable
fun SubScreen() {
    Column {
        Text("Second screen")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubScreenPreview() {
    SampleAppTheme {
        SubScreen()
    }
}
