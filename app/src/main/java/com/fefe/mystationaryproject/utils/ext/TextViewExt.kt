package com.fefe.mystationaryproject.utils.ext

import android.support.annotation.StringRes
import android.view.View
import android.widget.TextView

fun TextView.setTextIfNullGone(message: CharSequence?) {
    if (message.isNullOrBlank()) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
        text = message
    }
}

fun TextView.setTextIfNullGone(@StringRes resId: Int, vararg formatArgs: Any?) {
    if (formatArgs.contains(null) || formatArgs.contains("")) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
        text = context.getString(resId, *formatArgs)
    }
}