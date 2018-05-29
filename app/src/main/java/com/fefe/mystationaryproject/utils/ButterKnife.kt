package com.fefe.mystationaryproject.utils

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View

fun <V : View> Activity.bindView(@IdRes idRes: Int) = lazy<V> { findViewById(idRes) }

fun <V : View> View.bindView(@IdRes idRes: Int) = lazy<V> { findViewById(idRes) }

fun <V : View> RecyclerView.ViewHolder.bindView(@IdRes idRes: Int) = lazy<V> { itemView.findViewById(idRes) }