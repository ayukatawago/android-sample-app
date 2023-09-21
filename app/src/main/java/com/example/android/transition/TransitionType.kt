package com.example.android.transition

import com.example.android.R

enum class TransitionType(val description: String, val openAnimRes: Int, val closeAnimRes: Int) {
    ANDROID_SLIDE(
        "Android horizontal slide",
        android.R.anim.slide_in_left,
        android.R.anim.slide_out_right
    ),
    ANDROID_FADE(
        "Android fade in/out",
        android.R.anim.fade_in,
        android.R.anim.fade_out
    ),
    MY_SLIDE(
        "Slide up/down",
        R.anim.my_slide_up,
        R.anim.my_slide_down
    )
}
