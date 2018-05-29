package com.fefe.mystationaryproject.utils.ext

import android.app.Activity
import com.fefe.mystationaryproject.R

fun Activity.slideLeft() {
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
}

fun Activity.slideRight() {
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
}

fun Activity.slideUp() {
    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
}

fun Activity.slideDown() {
    overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down)
}