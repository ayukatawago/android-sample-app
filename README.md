# Android Sample app

This app is to check the function `overrideActivityTransition` introduced from SDK 34.

## Android 14 behavior
### Open with fade animation

This uses fade in/out animation provided by Android framework.
`android.R.anim.fade_in` is to open `SubActivity` and `android.R.anim.fade_out` is to close it.

<img src="docs/resized_anim_android_fade.gif" width="200">

### Open with slide animation

This also uses fade in/out animation provided by Android framework.
`android.R.anim.slide_in_left` is to open `SubActivity` and `android.R.anim.slide_out_right` is to close it.

<img src="docs/resized_anim_android_slide.gif" width="200">

### Open with my own slide animation
This uses the animation added to this project by myself.
`R.anim.my_slide_up` is to open `SubActivity` and `R.anim.my_slide_down` is to close it.

<img src="docs/resized_anim_my_slide.gif" width="200">

No slide animation happens though `overrideActivityTransition` is called same as others.
It seems this only happens `appcompat` library is added to the dependency.

```gradle
    implementation("androidx.appcompat:appcompat:1.6.1")
```
