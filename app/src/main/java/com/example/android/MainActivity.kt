package com.example.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.android.ui.ActivityTransitionScreen
import com.example.android.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppTheme {
                ActivityTransitionScreen(
                    onOpenSubActivityWithFade = { openActivityWithAnimation(AnimationType.ANDROID_FADE) },
                    onOpenSubActivityWithSlide = { openActivityWithAnimation(AnimationType.ANDROID_SLIDE) },
                    onOpenSubActivityWithMySlide = { openActivityWithAnimation(AnimationType.MY_SLIDE) }
                )
            }
        }
    }

    private fun openActivityWithAnimation(animationType: AnimationType) {
        val intent = SubActivity.createIntent(this, animationType)
        startActivity(intent)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU) {
            overridePendingTransition(animationType.openAnimRes, 0)
        }
    }
}
