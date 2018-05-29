package com.fefe.mystationaryproject.utils.ext

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import java.util.*

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.hideKeyboard(windowToken: IBinder) {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

/**
 * 通知用のPendingIntentを生成
 */
private fun createNotificationPendingIntent(
        context: Context,
        requestCode: Int,
        intent: Intent
): PendingIntent =
        PendingIntent.getBroadcast(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)


/**
 * アラームを設定
 */
private fun scheduleAlarm(context: Context, targetTime: Calendar, pendingIntent: PendingIntent) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, targetTime.timeInMillis,
                pendingIntent)
    } else {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, targetTime.timeInMillis,
                pendingIntent)
    }
}