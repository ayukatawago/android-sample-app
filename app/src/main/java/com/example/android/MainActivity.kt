package com.example.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.android.browser.BrowserActivity
import com.example.android.browser.UrlItem
import com.example.android.transition.SubActivity
import com.example.android.transition.TransitionType
import com.example.android.ui.ActivityTransitionScreen
import com.example.android.ui.BrowserEntryScreen
import com.example.android.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppTheme {
                AppType.BROWSER.ToCompose()
            }
        }
    }

    @Composable
    private fun AppType.ToCompose() =
        when (this) {
            AppType.ACTIVITY_TRANSITION -> ActivityTransitionScreen(::openActivityWithAnimation)

            AppType.BROWSER -> BrowserEntryScreen(::openBrowser)
        }

    private fun openActivityWithAnimation(transitionType: TransitionType) {
        val intent = SubActivity.createIntent(this, transitionType)
        startActivity(intent)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU) {
            overridePendingTransition(transitionType.openAnimRes, 0)
        }
    }

    private fun openBrowser(urlItem: UrlItem) {
        val intent = BrowserActivity.createIntent(this, urlItem.url)
        startActivity(intent)
    }
}
