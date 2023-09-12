package com.example.android

enum class AnimationType(val openAnimRes: Int, val closeAnimRes: Int) {
    ANDROID_SLIDE(android.R.anim.slide_in_left, android.R.anim.slide_out_right),
    ANDROID_FADE(android.R.anim.fade_in, android.R.anim.fade_out),
    MY_SLIDE(R.anim.my_slide_up, R.anim.my_slide_down)
}
