package com.fefe.mystationaryproject.utils

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.OnTabSelectedListener
import android.support.design.widget.TabLayout.Tab
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.transition.Transition
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS

/**
 * Created by yminagawa on 2017/09/13.
 */

inline fun View.clicks(crossinline onClick: () -> Unit) {
  setOnClickListener { onClick() }
}

inline fun View.waitClicks(crossinline onClick: () -> Unit) {
  setOnClickListener {
    isEnabled = false

    Observable.timer(1500, MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { isEnabled = true }

    onClick()
  }
}

inline fun TextView.afterTextChange(crossinline onAfterTextChanged: (text: String) -> Unit) {
  addTextChangedListener(object : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
    override fun afterTextChanged(s: Editable?) = onAfterTextChanged(s.toString())
  })
}

inline fun SwipeRefreshLayout.refreshes(crossinline onRefresh: () -> Unit) {
  setOnRefreshListener { onRefresh() }
}

inline fun Toolbar.navigationClicks(crossinline onNavigationClick: () -> Unit) {
  setNavigationOnClickListener { onNavigationClick() }
}

inline fun TabLayout.tabSelects(crossinline onTabSelected: (tab: Tab) -> Unit) {
  addOnTabSelectedListener(
      object : OnTabSelectedListener {
        override fun onTabReselected(tab: Tab) = Unit
        override fun onTabUnselected(tab: Tab) = Unit
        override fun onTabSelected(tab: Tab) = onTabSelected(tab)
      })
}

inline fun EditText.searchActions(crossinline onSearch: () -> Unit) {
  this.setOnEditorActionListener { _, actionId, _ ->
    var handle = false
    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
      onSearch()
      handle = true
    }
    handle
  }
}

inline fun Animator.animatorListener(
    crossinline onStart: (Animator) -> Unit,
    crossinline onEnd: (Animator) -> Unit,
    noinline onCancel: (Animator) -> Unit = {},
    noinline onRepeat: (Animator) -> Unit = {}
) {
  addListener(object : AnimatorListener {
    override fun onAnimationStart(animation: Animator) = onStart(animation)
    override fun onAnimationEnd(animation: Animator) = onEnd(animation)
    override fun onAnimationCancel(animation: Animator) = onCancel(animation)
    override fun onAnimationRepeat(animation: Animator) = onRepeat(animation)
  })
}


inline fun Transition.transitionListener(
    crossinline onStart: (Transition) -> Unit,
    crossinline onEnd: (Transition.TransitionListener, Transition) -> Unit,
    noinline onCancel: (Transition) -> Unit = {},
    noinline onResume: (Transition) -> Unit = {},
    noinline onPause: (Transition) -> Unit = {}
) {
  addListener(object : Transition.TransitionListener {
    override fun onTransitionStart(transition: Transition) = onStart(transition)
    override fun onTransitionEnd(transition: Transition) = onEnd(this, transition)
    override fun onTransitionCancel(transition: Transition) = onCancel(transition)
    override fun onTransitionResume(transition: Transition) = onResume(transition)
    override fun onTransitionPause(transition: Transition) = onPause(transition)
  })
}
