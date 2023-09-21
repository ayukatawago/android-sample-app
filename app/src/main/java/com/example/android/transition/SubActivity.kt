package com.example.android.transition

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import com.example.android.ui.SubScreen
import com.example.android.ui.theme.SampleAppTheme

class SubActivity : ComponentActivity() {
    private val transitionType: TransitionType? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(ANIMATION_TYPE, TransitionType::class.java)
        } else {
            intent.getSerializableExtra(ANIMATION_TYPE) as? TransitionType
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SampleAppTheme {
                SubScreen()
            }
        }

        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
                val closeAnimRes = transitionType?.closeAnimRes ?: return
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU) {
                    overridePendingTransition(0, closeAnimRes)
                }
            }
        })

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
            val animType = transitionType ?: return
            overrideActivityTransition(
                Activity.OVERRIDE_TRANSITION_OPEN,
                animType.openAnimRes,
                0
            )
            overrideActivityTransition(
                Activity.OVERRIDE_TRANSITION_CLOSE,
                0,
                animType.closeAnimRes
            )
        }
    }

    companion object {
        private const val ANIMATION_TYPE = "animation_type"
        fun createIntent(context: Context, transitionType: TransitionType): Intent =
            Intent(context, SubActivity::class.java).apply {
                putExtra(ANIMATION_TYPE, transitionType)
            }
    }
}
