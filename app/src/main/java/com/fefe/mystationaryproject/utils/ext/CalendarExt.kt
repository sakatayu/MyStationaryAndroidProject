package com.fefe.mystationaryproject.utils.ext

import java.util.*

fun Calendar.dayBefore(anotherCalendar: Calendar): Boolean {
    //日付だけを比較するため時分秒を取り除く
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.set(Calendar.MINUTE, 0)
    this.set(Calendar.SECOND, 0)
    this.set(Calendar.MILLISECOND, 0)

    anotherCalendar.set(Calendar.HOUR_OF_DAY, 0)
    anotherCalendar.set(Calendar.MINUTE, 0)
    anotherCalendar.set(Calendar.SECOND, 0)
    anotherCalendar.set(Calendar.MILLISECOND, 0)

    return this.before(anotherCalendar)
}

fun Calendar.dayAfter(anotherCalendar: Calendar): Boolean {
    //日付だけを比較するため時分秒を取り除く
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.set(Calendar.MINUTE, 0)
    this.set(Calendar.SECOND, 0)
    this.set(Calendar.MILLISECOND, 0)

    anotherCalendar.set(Calendar.HOUR_OF_DAY, 0)
    anotherCalendar.set(Calendar.MINUTE, 0)
    anotherCalendar.set(Calendar.SECOND, 0)
    anotherCalendar.set(Calendar.MILLISECOND, 0)

    return this.after(anotherCalendar)
}

fun Calendar.getDiffDays(anotherCalendar: Calendar): Int {
    //日付だけを比較するため時分秒を取り除く
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.set(Calendar.MINUTE, 0)
    this.set(Calendar.SECOND, 0)
    this.set(Calendar.MILLISECOND, 0)

    anotherCalendar.set(Calendar.HOUR_OF_DAY, 0)
    anotherCalendar.set(Calendar.MINUTE, 0)
    anotherCalendar.set(Calendar.SECOND, 0)
    anotherCalendar.set(Calendar.MILLISECOND, 0)


    //ミリ秒単位での差分
    val diffTime = anotherCalendar.timeInMillis - this.timeInMillis
    //日単位での差分に変換
    val MILLIS_OF_DAY = 1000 * 60 * 60 * 24
    val diffDays = (diffTime / MILLIS_OF_DAY).toInt()

    return diffDays
}

fun Calendar.getDiffWeeks(anotherCalendar: Calendar): Int {
    //日付だけを比較するため時分秒を取り除く
    val firstDateOfWeek1 = this.getFirstDateOfWeek()
    firstDateOfWeek1.set(Calendar.HOUR_OF_DAY, 0)
    firstDateOfWeek1.set(Calendar.MINUTE, 0)
    firstDateOfWeek1.set(Calendar.SECOND, 0)
    firstDateOfWeek1.set(Calendar.MILLISECOND, 0)

    val firstDateOfWeek2 = anotherCalendar.getFirstDateOfWeek()
    firstDateOfWeek2.set(Calendar.HOUR_OF_DAY, 0)
    firstDateOfWeek2.set(Calendar.MINUTE, 0)
    firstDateOfWeek2.set(Calendar.SECOND, 0)
    firstDateOfWeek2.set(Calendar.MILLISECOND, 0)

    //ミリ秒単位での差分
    val diffTime = firstDateOfWeek2.timeInMillis - firstDateOfWeek1.timeInMillis
    //日単位での差分に変換
    val MILLIS_OF_DAY = 1000 * 60 * 60 * 24
    val diffDays = (diffTime / MILLIS_OF_DAY).toInt()
    //週単位での差分に変換
    val diffWeeks = diffDays / 7

    return diffWeeks
}

/**
 * 週の初めの日(日曜日)を返す
 */
fun Calendar.getFirstDateOfWeek(): Calendar {
    val firstDateOfWeek = Calendar.getInstance()
    firstDateOfWeek.set(this.get(Calendar.YEAR), this.get(Calendar.MONTH),
            this.get(Calendar.DAY_OF_MONTH))
    firstDateOfWeek.add(Calendar.DAY_OF_MONTH, Calendar.SUNDAY - this.get(Calendar.DAY_OF_WEEK))
    return firstDateOfWeek
}

/**
 * 同じ日付のカレンダーかどうか
 *
 * @param anotherCalendar 比較対象のCalendar
 * @return 判定結果（true: 同じ日付, false: 別の日付）
 */
fun Calendar.isSameDay(anotherCalendar: Calendar): Boolean {
    val year = this.get(Calendar.YEAR)
    val month = this.get(Calendar.MONTH)
    val day = this.get(Calendar.DATE)

    val anotherYear = anotherCalendar.get(Calendar.YEAR)
    val anotherMonth = anotherCalendar.get(Calendar.MONTH)
    val anotherDay = anotherCalendar.get(Calendar.DATE)

    return year == anotherYear && month == anotherMonth && day == anotherDay
}