package com.fefe.mystationaryproject.utils.ext

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View

fun View.startActivity(intent: Intent) = context.startActivity(intent)

fun View.startActivityForResult(intent: Intent, requestCode: Int) =
        (context as AppCompatActivity).startActivityForResult(intent, requestCode)