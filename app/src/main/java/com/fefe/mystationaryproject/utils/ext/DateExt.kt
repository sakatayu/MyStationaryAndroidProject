package com.fefe.mystationaryproject.utils.ext

import java.util.*

/**
 * 同じ日付かどうか比較する
 *
 * @param anotherDate 比較対象の日付
 * @return 判定結果（true: 同じ日付, false: 別の日付）
 */
fun Date.isSameDay(anotherDate: Date): Boolean {
    val calendar = Calendar.getInstance().also { it.time = this }
    val anotherCalendar = Calendar.getInstance().also { it.time = anotherDate }

    return calendar.isSameDay(anotherCalendar)
}

/**
 * 日付の差分を返す
 *
 * @param targetDate 比較対象の日付
 */
fun Date.getDiffDays(targetDate: Date): Int {
    val calendar = Calendar.getInstance().also { it.time = this }
    val targetCalendar = Calendar.getInstance().apply { time = targetDate }

    return calendar.getDiffDays(targetCalendar)
}

/**
 * 比較対象日よりも前の日付か
 *
 * @param anotherDate 比較対象日
 */
fun Date.isBefore(anotherDate: Date): Boolean {
    val calendar = Calendar.getInstance().also { it.time = this }
    val anotherCalendar = Calendar.getInstance().also { it.time = anotherDate }

    return calendar.dayBefore(anotherCalendar)
}